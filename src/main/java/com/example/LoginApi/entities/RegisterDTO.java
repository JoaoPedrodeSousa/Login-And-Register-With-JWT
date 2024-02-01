package com.example.LoginApi.entities;

public class RegisterDTO {

    private String username;
    private String password;

    public RegisterDTO() {
    }

    public RegisterDTO(String username, String password) {
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
