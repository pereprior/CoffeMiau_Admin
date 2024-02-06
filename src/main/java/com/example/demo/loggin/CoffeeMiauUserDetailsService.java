package com.example.demo.loggin;

import com.example.demo.models.entities.Usuario;
import com.example.demo.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CoffeeMiauUserDetailsService implements UserDetailsService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = repositorioUsuario.findByUsernameOrEmail(username, null).get();
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CoffeeMiauUserDetails(usuario);
    }
}