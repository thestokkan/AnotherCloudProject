package com.example.anothercloudproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class AnotherCloudProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(AnotherCloudProjectApplication.class, args);
  }

  @GetMapping("/")
  public String helloWorld(@RequestParam(defaultValue = "Cloud") String name) {
    return "Hello " + name;
  }

  @GetMapping("/user-agent")
  public String userAgent(HttpServletRequest request) {
    return request.getHeader("User-Agent");
  }
}