package com.example.demo.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="gatos")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Gato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_gato")
    private Long idGato;

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

    @Column(name = "caracter")
    private String caracter;

    @NotBlank
    @NotEmpty
    @Column(name = "informacion_medica", nullable = false)
    private String informacionMedica;

    @NotBlank
    @NotEmpty
    @Column(name = "enfermadades", nullable = false)
    private String enfermedades;

    @Column(name = "castrado")
    private Boolean castrado;

    public Long getIdGato() {
        return idGato;
    }

    public void setIdGato(Long idGato) {
        this.idGato = idGato;
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
}