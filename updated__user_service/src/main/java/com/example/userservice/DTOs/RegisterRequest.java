package com.example.userservice.DTOs;

import com.example.userservice.Entitis.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String fullName;
    private String password;
    private Role role;
}
