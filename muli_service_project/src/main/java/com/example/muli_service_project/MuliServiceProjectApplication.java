package com.example.muli_service_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableFeignClients(basePackages = "com.example.courseservise")

@SpringBootApplication
public class MuliServiceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuliServiceProjectApplication.class, args);
    }

}
