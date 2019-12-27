package com.kpatil.microservices.geotracker.lb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeotrackerZKLoadBalancer {

  public static void main(String[] args) {
    SpringApplication.run(GeotrackerZKLoadBalancer.class, args);
  }
}

