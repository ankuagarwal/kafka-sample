package com.kafka.encoder;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.event.Message;

public class MessageDecoder implements Deserializer<Message> {

  public void configure(Map<String, ?> configs, boolean isKey) {
    // TODO Auto-generated method stub
  }

  public Message deserialize(String topic, byte[] data) {
    ObjectMapper objectMapper = new ObjectMapper();
    Message message = null;

    try {
      message = objectMapper.readValue(data, Message.class);
    } catch (Exception e) {
      System.out.println("Unable to read value as event " + e.getMessage());
    }
    return message;
  }

  public void close() {
    // TODO Auto-generated method stub
  }
}
