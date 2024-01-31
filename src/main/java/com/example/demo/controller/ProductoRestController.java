package com.example.demo.controller;

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

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.update(producto);
    }

    @PutMapping("/{productId}")
    public Producto updateProducto(@PathVariable Long productId, @RequestBody Producto producto) {
        producto.setId_producto(productId);
        return productoService.update(producto);
    }

    @DeleteMapping("/{productId}")
    public void deleteProducto(@PathVariable Long productId) {
        productoService.delete(productId);
    }
}
