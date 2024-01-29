package com.example.demo.models.services;

import com.example.demo.models.entities.Gato;

import java.util.List;

public interface IGatoService {
    public List<Gato> findAll();

    public void save(Gato gato);

    public Gato findById(Long id);

    public void delete(Gato gato);
}