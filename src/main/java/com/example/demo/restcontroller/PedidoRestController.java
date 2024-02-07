package com.example.demo.restcontroller;

import com.example.demo.models.entities.Pedido;
import com.example.demo.models.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.findAll();

        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long pedidoId) {
        Pedido pedido = pedidoService.findById(pedidoId);
        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        pedidoService.save(pedido);
        Pedido savedPedido = pedidoService.findById(pedido.getId());
        return new ResponseEntity<>(savedPedido, HttpStatus.CREATED);
    }
}
