package com.example.demo.restcontroller;

import com.example.demo.models.entities.Gato;
import com.example.demo.models.entities.GatoAdoptado;
import com.example.demo.models.services.IGatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gatos")
public class GatoRestController {

    @Autowired
    private IGatoService gatoService;

    @GetMapping("/noAdoptados")
    public ResponseEntity<List<Gato>> getAllGatos() {
        List<Gato> gatos = gatoService.findAllGatos();
        return new ResponseEntity<>(gatos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gato> getGatoById(@PathVariable Long id) {
        Gato gato = gatoService.findById(id);
        if (gato != null) {
            return new ResponseEntity<>(gato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
