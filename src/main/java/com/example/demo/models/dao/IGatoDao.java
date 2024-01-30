package com.example.demo.models.dao;

import com.example.demo.models.entities.Gato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGatoDao extends CrudRepository<Gato, Long> {
    @Query("SELECT g FROM Gato g WHERE TYPE(g) = Gato")
    List<Gato> findAllGatos();
}
