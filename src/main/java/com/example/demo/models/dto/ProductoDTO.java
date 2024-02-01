package com.example.demo.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductoDTO {
    @JsonProperty("id")
    private Long idProducto;

    @JsonProperty("url")
    private String url;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
