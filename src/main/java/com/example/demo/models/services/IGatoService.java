package com.example.demo.models.services;

import com.example.demo.models.entities.Gato;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IGatoService {
    public List<Gato> findAll();

    @Transactional(readOnly= true)
    List<Gato> findAllGatos();

    public void save(Gato gato);

    public Gato findById(Long id);

    public void delete(Gato gato);

    void adoptarGato(Long idGato);

}