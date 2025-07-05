package com.example.courseservise.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "user-service", configuration = FeignClientConfig.class)
public interface AuthClient {

    @GetMapping("/auth/validate")
    void validate(@RequestHeader("Authorization") String authHeader);
}
