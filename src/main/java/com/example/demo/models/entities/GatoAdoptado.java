package com.example.demo.models.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "gatos_adoptados")
public class GatoAdoptado extends Gato{

    @Column(name = "id_propietario")
    private Long idPropietario;

    @Column(name = "nombre_propietario")
    private String nombre_propietario;

    @Column(name = "apellido_propietario")
    private String apellido_propietario;
    @Column(name = "fecha_adopcion")
    private LocalDate fechaAdopcion;


    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombrePropietario() {
        return nombre_propietario;
    }

    public void setNombre_propietario(String nombre_propietario) {
        this.nombre_propietario = nombre_propietario;
    }

    public String getApellidoPropietario() {
        return apellido_propietario;
    }

    public void setApellido_propietario(String apellido_propietario) {
        this.apellido_propietario = apellido_propietario;
    }

    public LocalDate getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(LocalDate fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }
}