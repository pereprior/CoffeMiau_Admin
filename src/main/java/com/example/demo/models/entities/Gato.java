package com.example.demo.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="gatos")
public class Gato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gato")
    private Long id_gato;

    @NotBlank
    @NotEmpty
    @Column(name = "nombre_gato", nullable = false)
    private String nombre;

    @Column(name = "foto_gato")
    private String foto;
    @Column(name = "color")
    private String color;

    @Column(name = "raza")
    private String raza;

    @Column(name = "dueño")
    private String dueño;

    @Column(name = "caracter")
    private String caracter;

    @NotBlank
    @NotEmpty
    @Column(name = "informacion_medica", nullable = false)
    private String informacion_medica;

    @NotBlank
    @NotEmpty
    @Column(name = "enfermadades", nullable = false)
    private String enfermedades;

    @Column(name = "castrado", nullable = false)
    private Boolean castrado;

    public Long getId_gato() {
        return id_gato;
    }

    public void setId_gato(Long id_gato) {
        this.id_gato = id_gato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public String getInformacion_medica() {
        return informacion_medica;
    }

    public void setInformacion_medica(String informacion_medica) {
        this.informacion_medica = informacion_medica;
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
}