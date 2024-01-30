package com.example.demo.controller;

import com.example.demo.models.entities.LinPedido;
import com.example.demo.models.services.LinPedidoService;
import com.example.demo.models.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LinPedidoController {
    @Autowired
    private LinPedidoService linPedidoService;
    @Autowired
    private ProductoService productoService;

    @GetMapping("/linPedido")
    public String showLinPedidos(Model model){
        model.addAttribute("linpedidos",linPedidoService.findAll());
        model.addAttribute("currentPage", "linpedido");
        return "show_linpedidos";
    }

    @GetMapping("/linPedido/save")
    public String createLinPedido(Model model) {
        model.addAttribute("linpedido", new LinPedido());
        model.addAttribute("currentPage", "linpedido");
        model.addAttribute("productos",productoService.findAll());
        return "save_linpedido";
    }

    @PostMapping("/linPedido/saveLinPedido")
    public String saveLinPedido(@ModelAttribute LinPedido linPedido) {
        linPedidoService.update(linPedido);
        return "redirect:/linPedido";
    }

    @GetMapping("/linPedido/{linPedidoId}")
    public String updateLinPedido(@PathVariable Long linPedidoId, Model model) {
        LinPedido linPedido = linPedidoService.findById(linPedidoId);
        model.addAttribute("linpedido", linPedido);
        model.addAttribute("productos",productoService.findAll());
        return "edit_linpedido";
    }

    @PostMapping("/linPedido/deleteLinPedido/{linPedidoId}")
    public String deleteLinPedido(@PathVariable Long linPedidoId) {
        linPedidoService.delete(linPedidoId);
        return "redirect:/linPedido";
    }
}
