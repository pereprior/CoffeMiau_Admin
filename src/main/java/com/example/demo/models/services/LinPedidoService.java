package com.example.demo.models.services;

import com.example.demo.models.entity.LinPedido;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LinPedidoService implements ILinPedidoService {
    @Autowired
    private ILinPedidoService iLinPedidoService;

    @Override
    public List<LinPedido> findAll() {
        return iLinPedidoService.findAll();
    }

    @Override
    public LinPedido findById(Long id) {
        return iLinPedidoService.findById(id);
    }

    @Override
    public LinPedido update(LinPedido linPedido) {
        return iLinPedidoService.update(linPedido);
    }

    @Override
    public void delete(Long id) {
        iLinPedidoService.delete(id);
    }
}
