package com.example.courseservise.feign;

import com.example.courseservise.config.FeignClientConfig;
import com.example.courseservise.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "user-service", configuration = FeignClientConfig.class)

public interface UserServiceClient {

    @GetMapping("/auth/user/{id}")
    UserDTO getUserById(@PathVariable("id") Long userId);
}
