package com.example.demo.jwt;

import com.example.demo.models.dao.IUsuarioTokenDao;
import com.example.demo.models.entities.Usuario;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final IUsuarioTokenDao iUsuarioTokenDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(IUsuarioTokenDao iUsuarioTokenDao, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.iUsuarioTokenDao = iUsuarioTokenDao;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(Usuario request) {
        Usuario usuario = new Usuario();
        usuario.setUsername(request.getUsername());
        usuario.setEmail(request.getEmail());
        usuario.setTelefono(request.getTelefono());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setRol(request.getRol());

        usuario = iUsuarioTokenDao.save(usuario);

        String token = jwtService.generateToken(usuario);

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(Usuario request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        Usuario usuario = iUsuarioTokenDao.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(usuario);

        return new AuthenticationResponse(token);
    }
}
