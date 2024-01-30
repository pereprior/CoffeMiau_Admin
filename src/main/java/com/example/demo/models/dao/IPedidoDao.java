package com.example.demo.models.dao;

import com.example.demo.models.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoDao extends JpaRepository<Pedido, Long> {
}