package com.example.demo.controller;

import com.example.demo.models.entities.Producto;
import com.example.demo.models.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/product")
    public String showProducts(Model model){
        model.addAttribute("products",productoService.findAll());
        model.addAttribute("currentPage", "product");
        return "show_products";
    }

    @GetMapping("/product/save")
    public String createProduct(Model model) {
        model.addAttribute("product", new Producto());
        model.addAttribute("currentPage", "product");
        return "save_product";
    }

    @PostMapping("/product/saveProduct")
    public String saveProduct(@ModelAttribute Producto producto) {
        productoService.update(producto);
        return "redirect:/product";
    }

    @GetMapping("/product/{productId}")
    public String updateProduct(@PathVariable Long productId, Model model) {
        Producto producto = productoService.findById(productId);
        model.addAttribute("product", producto);
        return "edit_product";
    }

    @PostMapping("/product/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        productoService.delete(productId);
        return "redirect:/product";
    }
}
