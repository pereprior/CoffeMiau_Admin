package com.example.demo.models.dao;

import com.example.demo.models.entities.LinPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILinPedidoDAO extends JpaRepository<LinPedido, Long> {
}
