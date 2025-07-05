package com.example.courseservise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.courseservise.feign")

public class CourseServiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseServiseApplication.class, args);
    }

}
