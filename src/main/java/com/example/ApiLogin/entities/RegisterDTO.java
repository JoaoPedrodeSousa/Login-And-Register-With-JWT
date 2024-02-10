package com.example.ApiLogin.entities;

public record RegisterDTO(String username, String password) {
    public RegisterDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

