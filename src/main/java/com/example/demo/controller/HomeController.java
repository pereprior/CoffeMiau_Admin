package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(@RequestParam(name = "nombre", required = true, defaultValue = "Pere") String nombre, Model model) {
        model.addAttribute("nombre",nombre);
        return "home";
    }

    @GetMapping("/systechsolutions")
    public String systechsolutions(@RequestParam(name = "systechsolutions", required = true, defaultValue = "Pere") String nombre, Model model) {
        model.addAttribute("systechsolutions",nombre);
        return "systechsolutions";
    }
}