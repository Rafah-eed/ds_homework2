package com.example.courseservise.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class AuthFilter extends OncePerRequestFilter {

    private final AuthClient authClient;

    @Lazy
    @Autowired
    public AuthFilter(AuthClient authClient) {
        this.authClient = authClient;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (request.getRequestURI().contains("/api/courses") && authHeader != null) {
            try {
                authClient.validate(authHeader);
            } catch (Exception e) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
