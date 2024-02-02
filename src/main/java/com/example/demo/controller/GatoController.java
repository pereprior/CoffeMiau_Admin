package com.example.demo.controller;

import com.example.demo.models.entities.Gato;
import com.example.demo.models.entities.GatoAdoptado;
import com.example.demo.models.entities.Usuario;
import com.example.demo.models.services.IGatoService;
import com.example.demo.models.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GatoController {

    @Autowired
    private IGatoService gatoService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listGatos")
    public String listGatos(Model model) {
        List<Gato> gatos = gatoService.findAllGatos();
        model.addAttribute("gatos", gatos);
        return "list_gatos";
    }

    @GetMapping("/listGatosAdoptados")
    @Secured("ROLE_EMPLEADO")
    public String listGatosAdoptados(Model model) {
        List<GatoAdoptado> gatosAdoptados = gatoService.findAllGatosAdoptados();
        model.addAttribute("gatos", gatosAdoptados);
        return "list_adoptados";
    }

    @GetMapping("/gatos/formForAddGato")
    @Secured("ROLE_EMPLEADO")
    public String formForAddGato(Model model) {
        Gato gato = new Gato();
        model.addAttribute("gato", gato);
        return "form_gato";
    }

    @PostMapping("/gatos/saveGato")
    @Secured("ROLE_EMPLEADO")
    public String saveGato(@ModelAttribute("gato") Gato gato) {
        gatoService.save(gato);
        return "redirect:/listGatos";
    }

    @GetMapping("/gatos/formForUpdateGato")
    @Secured("ROLE_EMPLEADO")
    public String formForUpdateGato(@RequestParam("gatoId") Long id, Model model) {
        Gato gato = gatoService.findById(id);
        model.addAttribute("gato", gato);
        return "form_gato";
    }

    @GetMapping("/gatos/deleteGato")
    @Secured("ROLE_ADMIN")
    public String deleteGato(@RequestParam("gatoId") Long id) {
        Gato gato = gatoService.findById(id);
        gatoService.delete(gato);
        return "redirect:/listGatos";
    }

    @GetMapping("/gatos/formForAdopcion")
    @Secured("ROLE_EMPLEADO")
    public String formForAdopcion(@RequestParam("gatoId") Long id, Model model) {
        Gato gato = gatoService.findById(id);
        List<Usuario> usuarios = usuarioService.findAll();

        model.addAttribute("gato", gato);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("gato_adoptado", new GatoAdoptado());

        return "formulario_adopcion";
    }

    @PostMapping("gatos/adoptar")
    @Secured("ROLE_EMPLEADO")
    public String adoptarGato(@ModelAttribute("gato_adoptado") GatoAdoptado gatoParaAdopcion,
                              @RequestParam("clienteId") Long clienteId) {
        try {
            Usuario cliente = usuarioService.findById(clienteId);

            if (cliente != null) {
                gatoParaAdopcion.setIdPropietario(cliente.getId());
                gatoParaAdopcion.setNombrePropietario(cliente.getNombre());

                gatoService.adoptarGato(gatoParaAdopcion.getIdGato(), cliente.getId());
                return "redirect:/listGatos";
            } else {
                return "redirect:/listGatos";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/listGatos";
        }
    }
}
