package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.kafka.event.Message;

public class SampleProducer {

  private KafkaProducer<String, Message> producer = null;

  public SampleProducer() {
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092"); // Message broker list
    props.put("value.serializer", "com.kafka.encoder.MessageEncoder"); // Serializer class for
                                                                       // message
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("acks", "all");

    producer = new KafkaProducer<String, Message>(props);
  }

  public void publish(String key, Message message) {
    System.out.println("Publishing key " + key + " message " + message);
    producer.send(new ProducerRecord<String, Message>("test", key, message)); // Topic, Key, Value
  }

}
