package com.example.demo.controller;

import com.example.demo.models.entities.Pedido;
import com.example.demo.models.entities.Usuario;
import com.example.demo.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        List<Usuario> listaUsuarios = service.findAll();
        model.addAttribute("usuarios", listaUsuarios);
        return "usuarios";
    }

    @GetMapping("/usuarios/add")
    public String mostrarFormularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "add_usuario";
    }

    @PostMapping("/usuarios/add")
    public String crearNuevoUsuario(@ModelAttribute Usuario usuario) {
        service.save(usuario);
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/delete/{id}")
    public String borrarUsuario(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/edit/{id}")
    public String mostrarFormularioEditarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = service.findById(id);
        if (usuario == null) {
            return "redirect:/usuarios";
        }

        model.addAttribute("usuario", usuario);

        return "edit_usuario";
    }

    @PostMapping("/usuarios/edit")
    public String actualizarUsuario(@ModelAttribute Usuario usuario) {
        if (usuario == null) {
            return "redirect:/usuarios";
        }

        service.save(usuario);

        return "redirect:/usuarios";
    }
}

