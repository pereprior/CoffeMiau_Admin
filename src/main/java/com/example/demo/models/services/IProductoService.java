package com.example.demo.models.services;


import com.example.demo.models.entities.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto update(Producto producto);
    void delete(Long id);
}
