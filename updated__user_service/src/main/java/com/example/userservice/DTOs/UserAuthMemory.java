package com.example.userservice.DTOs;

import org.springframework.stereotype.Component;

@Component
public class UserAuthMemory {
    private String username;
    private String password;

    public void saveCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
