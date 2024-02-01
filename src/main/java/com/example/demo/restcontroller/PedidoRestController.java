package com.example.demo.restcontroller;

import com.example.demo.models.entities.Pedido;
import com.example.demo.models.dto.PedidoDTO;
import com.example.demo.models.dto.UsuarioDTO;
import com.example.demo.models.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PutMapping("/{pedidoId}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long pedidoId, @RequestBody Pedido pedido) {
        Pedido existingPedido = pedidoService.findById(pedidoId);

        if (existingPedido != null) {
            pedido.setId(pedidoId);
            pedidoService.save(pedido);
            Pedido updatedPedido = pedidoService.findById(pedido.getId());
            return new ResponseEntity<>(updatedPedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{pedidoId}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long pedidoId) {
        pedidoService.delete(pedidoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
