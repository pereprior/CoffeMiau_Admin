package com.example.demo.loggin;

import com.example.demo.models.entities.Usuario;
import com.example.demo.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeMiauUserImpl implements ICoffeeMiauUsuario {

    private final RepositorioUsuario repositorioUsuario;

    @Autowired
    public CoffeeMiauUserImpl(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public List<Usuario> getAllUsers() {
        return repositorioUsuario.findAll();
    }

    @Override
    public Optional<Usuario> getUserById(Long id) {
        return repositorioUsuario.findById(id);
    }

    @Override
    public Optional<Usuario> getUserByUsernameOrEmail(String username, String email) {
        return repositorioUsuario.findByUsernameOrEmail(username, email); }

    @Override
    public Usuario createUser(Usuario user) {
        return repositorioUsuario.save(user);
    }

    @Override
    public Usuario updateUser(Long id, Usuario updatedUser) {
        Optional<Usuario> existingUser = repositorioUsuario.findById(id);

        if (existingUser.isPresent()) {
            Usuario userToUpdate = existingUser.get();
            userToUpdate.setUsername(updatedUser.getUsername());
            userToUpdate.setEmail(updatedUser.getEmail());
            userToUpdate.setPassword(updatedUser.getPassword());
            userToUpdate.setTelefono(updatedUser.getTelefono());
            userToUpdate.setRol(updatedUser.getRol());
            return repositorioUsuario.save(userToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUser(Long id) {
        repositorioUsuario.deleteById(id);
    }
}