package com.example.demo.models.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private int telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    /*@Column(name = "gatos")
    private List<Gato> gatos;*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
