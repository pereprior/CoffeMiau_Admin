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

    @GetMapping
    public ResponseEntity<List<Gato>> getAll() {
        List<Gato> gatos = gatoService.findAll();
        return new ResponseEntity<>(gatos, HttpStatus.OK);
    }

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

    @PostMapping("/add")
    public ResponseEntity<Gato> createGato(@RequestBody Gato gato) {
        gatoService.save(gato);
        Gato savedGato = gatoService.findById(gato.getIdGato());
        return new ResponseEntity<>(savedGato, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gato> updateGato(@PathVariable Long id, @RequestBody Gato gato) {
        Gato existingGato = gatoService.findById(id);

        if (existingGato != null) {
            gato.setIdGato(id);
            gatoService.save(gato);
            Gato updatedGato = gatoService.findById(gato.getIdGato());
            return new ResponseEntity<>(updatedGato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGato(@PathVariable Long id) {
        Gato gato = gatoService.findById(id);
        if (gato != null) {
            gatoService.delete(gato);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adoptar/{idGato}/{idCliente}")
    public ResponseEntity<Void> adoptarGato(@PathVariable Long idGato, @PathVariable Long idCliente) {
        try {
            gatoService.adoptarGato(idGato, idCliente);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/adoptados")
    public ResponseEntity<List<GatoAdoptado>> getAllGatosAdoptados() {
        List<GatoAdoptado> gatosAdoptados = gatoService.findAllGatosAdoptados();
        return new ResponseEntity<>(gatosAdoptados, HttpStatus.OK);
    }
}
