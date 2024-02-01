package com.example.demo.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
