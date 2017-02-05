package com.kafka.encoder;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
public class MessageEncoder<Message> implements Serializer<Message> {

  public void configure(Map<String, ?> configs, boolean isKey) {
    // TODO Auto-generated method stub
  }

  public byte[] serialize(String topic, Message data) {
    ObjectMapper objectMapper = new ObjectMapper();

    byte[] bytes = null;
    try {
      bytes = objectMapper.writeValueAsBytes(data);
    } catch (JsonProcessingException e) {
      System.out.println("Unable to write value as bytes " + e.getMessage());
    }
    return bytes;
  }

  public void close() {
    // TODO Auto-generated method stub
  }
}
