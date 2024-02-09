package com.example.demo.restcontroller;

import com.example.demo.jwt.JwtService;
import com.example.demo.jwt.UsuarioTokenService;
import com.example.demo.models.dto.TokenDTO;
import com.example.demo.models.entities.Usuario;
import com.example.demo.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsuarioTokenService usuarioTokenService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Usuario> getUsuarioByName(@PathVariable String username) {
        Usuario usuario = usuarioService.findByName(username);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/me")
    public ResponseEntity<Usuario> getUserFromToken(
            @RequestBody TokenDTO tokenDTO
    ) {
        if (tokenDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        String token = tokenDTO.getToken();
        String username = jwtService.extractUsername(token);

        if (username != null) {
            Usuario usuario = (Usuario) usuarioTokenService.loadUserByUsername(username);
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
