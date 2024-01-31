package com.example.demo.models.services;

import com.example.demo.models.entities.Gato;
import com.example.demo.models.entities.GatoAdoptado;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IGatoService {
    public List<Gato> findAll();

    @Transactional(readOnly= true)
    List<Gato> findAllGatos();

    @Transactional(readOnly= true)
    List<GatoAdoptado> findAllGatosAdoptados();


    public void save(Gato gato);

    public Gato findById(Long id);

    public void delete(Gato gato);

    @Transactional
    void adoptarGato(Long idGato, Long idCliente);

}