package com.example.demo.models.services;

import com.example.demo.models.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    void save(Usuario usuario);

    Usuario findById(Long id);

    List<Usuario> findAll();

    void delete(Long id);
}
