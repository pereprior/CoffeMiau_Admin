package com.example.demo.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenDTO {
    @JsonProperty
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
