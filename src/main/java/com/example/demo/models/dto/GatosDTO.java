package com.example.demo.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GatosDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("urlFotoGato")
    private String urlFotoGato;
    @JsonProperty("color")
    private String color;

    @JsonProperty("raza")
    private String raza;

    @JsonProperty("caracter")
    private String caracter;

    @JsonProperty("informacionMedica")
    private String informacionMedica;

    @JsonProperty("enfermedades")
    private String enfermedades;

    @JsonProperty("castrado")
    private Boolean castrado;

    public Long getIdGato(){
        return id;
    }

    public void setIdGato(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFotoGato() {
        return urlFotoGato;
    }

    public void setUrlFotoGato(String urlFotoGato) {
        this.urlFotoGato = urlFotoGato;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public String getInformacionMedica() {
        return informacionMedica;
    }

    public void setInformacionMedica(String informacionMedica) {
        this.informacionMedica = informacionMedica;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }

    public String getColorUrl() {
        return color;
    }

}
