package com.example.AuthAPI.model.Entities;

public class LoginRes {
    private String token;

    public LoginRes(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
