package com.example.demo.models.services;

import com.example.demo.models.dao.ILinPedidoDAO;
import com.example.demo.models.entity.LinPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LinPedidoService implements ILinPedidoService {
    @Autowired
    private ILinPedidoDAO iLinPedidoDAO;

    @Override
    @Transactional
    public List<LinPedido> findAll() {
        return iLinPedidoDAO.findAll();
    }

    @Override
    @Transactional
    public LinPedido findById(Long id) {
        return iLinPedidoDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public LinPedido update(LinPedido linPedido) {
        return iLinPedidoDAO.save(linPedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iLinPedidoDAO.deleteById(id);
    }
}
