package com.example.demo.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Lin_Pedido")
public class LinPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lin_pedido")
    private Long id_lin_pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    public Long getId_lin_pedido() {
        return id_lin_pedido;
    }

    public void setId_lin_pedido(Long id_lin_pedido) {
        this.id_lin_pedido = id_lin_pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
