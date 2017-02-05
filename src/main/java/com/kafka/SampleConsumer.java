package com.kafka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.kafka.event.Message;

public class SampleConsumer {

  private KafkaConsumer<String, Message> consumer = null;

  public SampleConsumer() {
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092"); // Zookeeper Server
    props.put("group.id", "sample-consumer"); // Consumer Group
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("session.timeout.ms", "30000");
    props.put("value.deserializer", "com.kafka.encoder.MessageDecoder"); // Deserializer for Message
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    consumer = new KafkaConsumer<String, Message>(props);
    consumer.subscribe(Arrays.asList("test1")); // Topics it is subscribed to
  }

  public List<Message> consume() {
    List<Message> messages = new ArrayList<Message>();

    ConsumerRecords<String, Message> records = consumer.poll(0);
    for (ConsumerRecord<String, Message> record : records) {
      String key = record.key();
      Message message = record.value();
      System.out.println("Consumed key " + key + " Message " + message);
      messages.add(message);
    }

    return messages;
  }
}
