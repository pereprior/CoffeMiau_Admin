package com.example.demo.models.dao;

import com.example.demo.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioTokenDao extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
