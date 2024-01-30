package com.example.demo.models.services;

import com.example.demo.models.dao.IProductoDAO;
import com.example.demo.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoDAO iProductoDAO;

    @Override
    @Transactional
    public List<Producto> findAll() {
        return this.iProductoDAO.findAll();
    }

    @Override
    @Transactional
    public Producto findById(Long id) {
        return iProductoDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto update(Producto producto) {
        return iProductoDAO.save(producto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iProductoDAO.deleteById(id);
    }
}
