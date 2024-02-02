package com.example.demo.models.services;

import com.example.demo.models.dao.IPedidoDao;
import com.example.demo.models.entities.Pedido;
import com.example.demo.models.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PedidoService implements IPedidoService {

    private final IPedidoDao dao;

    @Autowired
    public PedidoService(IPedidoDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void save(Pedido pedido) {
        dao.save(pedido);
    }

    @Override
    @Transactional
    public Pedido findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Pedido> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Pedido> finByUser(Usuario usuario) {
        return dao.findByCliente(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(findById(id));
    }

}
