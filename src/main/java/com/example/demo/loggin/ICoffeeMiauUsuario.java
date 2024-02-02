package com.example.demo.loggin;

import com.example.demo.models.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface ICoffeeMiauUsuario {
    List<Usuario> getAllUsers();
    Optional<Usuario> getUserById(Long id);
    Optional<Usuario> getUserByUsernameOrEmail(String nombre, String email);
    Usuario createUser(Usuario usuario);
    Usuario updateUser(Long id, Usuario nuevoDatosUsuario);
    void deleteUser(Long id);
}