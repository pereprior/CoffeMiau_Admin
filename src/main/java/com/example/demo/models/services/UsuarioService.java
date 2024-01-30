package com.example.demo.models.services;

import com.example.demo.models.dao.IUsuarioDao;
import com.example.demo.models.entities.Usuario;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public class UsuarioService implements IUsuarioService {

    private final IUsuarioDao dao;

    @Autowired
    public UsuarioService(IUsuarioDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        dao.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

}

