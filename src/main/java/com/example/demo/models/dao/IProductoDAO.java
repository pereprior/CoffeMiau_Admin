package com.example.demo.models.dao;

import com.example.demo.models.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDAO extends JpaRepository<Producto, Long> {
}
