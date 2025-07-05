package com.example.courseservise.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String authorization = requestTemplate.request().headers().get("Authorization").stream()
                    .findFirst()
                    .orElse(null);

            if (authorization != null) {
                requestTemplate.header("Authorization", authorization);
            }
        };
    }
}
