package com.kafka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.event.Message;

public class SampleFileReader {

  public static void main(String[] args) {

    BufferedReader br = null;
    FileReader fr = null;
    String currentLine = null;

    ObjectMapper objectMapper = new ObjectMapper();
    SampleProducer producer = new SampleProducer();

    try {
      fr = new FileReader("input.txt"); // File Path
      br = new BufferedReader(fr);

      while ((currentLine = br.readLine()) != null) {
        Message message = objectMapper.readValue(currentLine, Message.class);
        producer.publish(message.getId(), message);
      }
    } catch (IOException e) {
      System.out.println("Error reading the file " + e.getMessage());
    } finally {
      try {
        if (br != null)
          br.close();
        if (fr != null)
          fr.close();
      } catch (IOException ex) {
        System.out.println("Error closing descriptors " + ex.getMessage());
      }
    }
  }
}
