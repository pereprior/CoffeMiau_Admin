package com.example.demo.models.services;

import com.example.demo.models.entities.Pedido;

import java.util.List;

public interface IPedidoService {
    void save(Pedido pedido);

    Pedido findById(Long id);

    List<Pedido> findAll();

    void delete(Long id);
}
