package com.example.readnode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReadNodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReadNodeApplication.class, args);
    }
}
