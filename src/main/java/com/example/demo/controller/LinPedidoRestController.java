package com.example.demo.controller;

import com.example.demo.models.entities.LinPedido;
import com.example.demo.models.services.LinPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/linPedido")
public class LinPedidoRestController {

    @Autowired
    private LinPedidoService linPedidoService;

    @GetMapping
    public ResponseEntity<List<LinPedido>> getAllLinPedidos() {
        List<LinPedido> linPedidos = linPedidoService.findAll();
        return new ResponseEntity<>(linPedidos, HttpStatus.OK);
    }

    @GetMapping("/{linPedidoId}")
    public ResponseEntity<LinPedido> getLinPedidoById(@PathVariable Long linPedidoId) {
        LinPedido linPedido = linPedidoService.findById(linPedidoId);
        if (linPedido != null) {
            return new ResponseEntity<>(linPedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveLinPedido")
    public ResponseEntity<LinPedido> saveLinPedido(@RequestBody LinPedido linPedido) {
        LinPedido savedLinPedido = linPedidoService.update(linPedido);
        return new ResponseEntity<>(savedLinPedido, HttpStatus.CREATED);
    }

    @PutMapping("/{linPedidoId}")
    public ResponseEntity<LinPedido> updateLinPedido(@PathVariable Long linPedidoId, @RequestBody LinPedido linPedido) {
        LinPedido existingLinPedido = linPedidoService.findById(linPedidoId);

        if (existingLinPedido != null) {
            linPedido.setId_lin_pedido(linPedidoId);
            LinPedido updatedLinPedido = linPedidoService.update(linPedido);
            return new ResponseEntity<>(updatedLinPedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteLinPedido/{linPedidoId}")
    public ResponseEntity<Void> deleteLinPedido(@PathVariable Long linPedidoId) {
        linPedidoService.delete(linPedidoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
