package com.example.demo.models.dao;

import com.example.demo.models.entities.Gato;
import org.springframework.data.repository.CrudRepository;

public interface IGatoDao extends CrudRepository<Gato, Long> {
}
