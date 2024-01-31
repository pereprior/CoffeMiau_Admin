package com.example.demo.controller;

import com.example.demo.models.entities.Pedido;
import com.example.demo.models.entities.PedidoDTO;
import com.example.demo.models.entities.Usuario;
import com.example.demo.models.entities.UsuarioDTO;
import com.example.demo.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();

        List<UsuarioDTO> usuarioDTO = usuarios.stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setTelefono(usuario.getTelefono());
        usuarioDTO.setRol(usuario.getRol());
        usuarioDTO.setUrl("/api/usuarios/" + usuario.getId());

        return usuarioDTO;

    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);
        if (usuario != null) {
            UsuarioDTO usuarioDTO = convertToDTO(usuario);
            return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
        Usuario savedUsuario = usuarioService.findById(usuario.getId());
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long usuarioId, @RequestBody Usuario usuario) {
        Usuario existingUsuario = usuarioService.findById(usuarioId);

        if (existingUsuario != null) {
            usuario.setId(usuarioId);
            usuarioService.save(usuario);
            Usuario updatedUsuario = usuarioService.findById(usuario.getId());
            return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{usuarioId}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long usuarioId) {
        usuarioService.delete(usuarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
