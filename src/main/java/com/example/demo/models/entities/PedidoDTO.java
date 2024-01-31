package com.example.demo.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoDTO {

    @JsonProperty("id")
    private Long idPedido;

    @JsonProperty("fecha")
    private String fecha;

    @JsonProperty("usuario")
    private UsuarioDTO usuarioDTO;

    @JsonProperty("url")
    private String url;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
