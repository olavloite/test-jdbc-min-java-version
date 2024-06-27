package com.google.cloud.example;

import com.google.cloud.spanner.connection.SpannerPool;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcApp {
  
  public static void main(String[] args) throws SQLException {
    try (Connection connection = DriverManager.getConnection("jdbc:cloudspanner:/projects/emulator-project/instances/test-instance/databases/my-database?autoConfigEmulator=true")) {
      try (ResultSet resultSet = connection.createStatement().executeQuery("select 'Hello world!'")) {
        while (resultSet.next()) {
          System.out.println(resultSet.getString(1));
        }
      }
    }
    SpannerPool.closeSpannerPool();
  }

}
