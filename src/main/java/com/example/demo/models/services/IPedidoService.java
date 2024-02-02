package com.example.demo.models.services;

import com.example.demo.models.entities.Pedido;
import com.example.demo.models.entities.Usuario;

import java.util.List;

public interface IPedidoService {
    void save(Pedido pedido);

    Pedido findById(Long id);

    List<Pedido> findAll();

    List<Pedido> finByUser(Usuario usuario);

    void delete(Long id);
}
