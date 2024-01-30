package com.example.demo.models.services;

import com.example.demo.models.entity.LinPedido;

import java.util.List;

public interface ILinPedidoService {
    List<LinPedido> findAll();
    LinPedido findById(Long id);
    LinPedido update(LinPedido linPedido);
    void delete(Long id);
}
