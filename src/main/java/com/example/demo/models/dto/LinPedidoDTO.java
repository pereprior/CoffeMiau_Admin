package com.example.demo.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinPedidoDTO {
    @JsonProperty
    private Long idLinPedido;

    @JsonProperty("url")
    private String url;

    public Long getIdLinPedido() {
        return idLinPedido;
    }

    public void setIdLinPedido(Long idLinPedido) {
        this.idLinPedido = idLinPedido;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
