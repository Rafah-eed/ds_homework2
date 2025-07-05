package com.example.courseservise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);

        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions().disable()) // H2 Console
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(mvc.pattern("/h2-console/**")).permitAll()
                        .requestMatchers(mvc.pattern("/actuator/**")).permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic();
        return http.build();
    }
}

