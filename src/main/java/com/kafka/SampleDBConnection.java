package com.kafka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import com.kafka.event.Message;

public class SampleDBConnection {

  public static void main(String[] args) {

    String DB_URL = "jdbc:mysql://localhost/sample"; // DB Name
    String USER = "username"; // DB username
    String PASS = "password"; // DB Password

    Connection conn = null;
    Statement stmt = null;

    SampleConsumer consumer = new SampleConsumer();

    try {

      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();

      while (true) {
        List<Message> messages = consumer.consume();
        for (Message message : messages) {
          String sql = "insert into message (`id`, `value`) values ('" + message.getId() + "', '"
              + message.getName() + "')";
          stmt.execute(sql);
        }
      }

    } catch (Exception e) {
      System.out.println("Error executing statement " + e.getMessage());
    } finally {
      try {
        if (stmt != null)
          stmt.close();
        if (conn != null)
          conn.close();
      } catch (Exception e) {
        System.out.println("Error closing connection  " + e.getMessage());
      }
    }
  }
}
