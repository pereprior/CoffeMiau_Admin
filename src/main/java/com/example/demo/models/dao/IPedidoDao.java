package com.example.demo.models.dao;

import com.example.demo.models.entities.Pedido;
import com.example.demo.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPedidoDao extends JpaRepository<Pedido, Long> {
    @Query("SELECT p FROM Pedido p WHERE p.cliente = ?1")
    List<Pedido> findByCliente(Usuario cliente);
}