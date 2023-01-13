package com.example.anothercloudproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@SpringBootApplication
public class AnotherCloudProjectApplication {
  @Autowired
  DataSource dataSource;

  public static void main(String[] args) {
    SpringApplication.run(AnotherCloudProjectApplication.class, args);
  }

  @GetMapping("/")
  public String helloWorld(@RequestParam(defaultValue = "Cloud") String name) {
    return "Hello " + name + "!";
  }

  @GetMapping("/user-agent")
  public String userAgent(HttpServletRequest request) {
    return request.getHeader("User-Agent");
  }

//  @GetMapping("/db")
//  public void db() {
//    try {
//      Connection c = dataSource.getConnection();
//      Statement stmt = c.createStatement();
//      stmt.execute("SELECT 1");
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//  }
}