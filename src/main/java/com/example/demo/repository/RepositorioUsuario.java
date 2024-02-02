package com.example.demo.repository;

import com.example.demo.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreOrEmail(String nombre, String email);
}


