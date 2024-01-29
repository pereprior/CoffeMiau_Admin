package com.example.demo.controller;

import com.example.demo.models.entities.Gato;
import com.example.demo.models.services.IGatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/gatos")
public class GatoController {

    @Autowired
    private IGatoService gatoService;

    @GetMapping("/listGatos")
    public String listGatos(Model model) {
        List<Gato> gatos = gatoService.findAll();
        model.addAttribute("gatos", gatos);
        return "list_gatos";
    }

    @GetMapping("/formForAddGatos")
    public String showFormForAddGato(Model model) {
        Gato gato = new Gato();
        model.addAttribute("gato", gato);
        return "form_gato";
    }

    @PostMapping("/saveGato")
    public String saveGato(@ModelAttribute("gato") Gato gato) {
        gatoService.save(gato);
        return "redirect:/gatos/listGatos";
    }

    @GetMapping("/formForUpdateGato")
    public String showFormForUpdateGato(@RequestParam("gatoId") Long id, Model model) {
        Gato gato = gatoService.findById(id);
        model.addAttribute("gato", gato);
        return "form_gato";
    }

    @GetMapping("/deleteGato")
    public String deleteGato(@RequestParam("gatoId") Long id) {
        Gato gato = gatoService.findById(id);
        gatoService.delete(gato);
        return "redirect:/gatos/listGatos";
    }
}