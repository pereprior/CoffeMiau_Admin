package com.example.demo.restcontroller;

import com.example.demo.models.entities.Producto;
import com.example.demo.models.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{productId}")
    public Producto getProductoById(@PathVariable Long productId) {
        return productoService.findById(productId);
    }
}
