package com.example.demo.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoDTO {

    @JsonProperty("id")
    private Long idPedido;

    @JsonProperty("url")
    private String url;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
