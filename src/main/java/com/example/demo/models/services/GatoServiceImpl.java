package com.example.demo.models.services;

import com.example.demo.models.dao.IGatoDao;
import com.example.demo.models.dao.IUsuarioDao;
import com.example.demo.models.entities.Gato;
import com.example.demo.models.entities.GatoAdoptado;
import com.example.demo.models.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class GatoServiceImpl implements IGatoService {
    @Autowired
    private IGatoDao gatoDao;

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly= true)
    public List<Gato> findAll() {
        return (List<Gato>) gatoDao.findAll();
    }

    @Override
    @Transactional(readOnly= true)
    public List<Gato> findAllGatos() {
        return (List<Gato>) gatoDao.findAllGatos();
    }

    @Override
    @Transactional(readOnly= true)
    public List<GatoAdoptado> findAllGatosAdoptados() {
        return (List<GatoAdoptado>) gatoDao.findAllGatosAdoptados();
    }

    @Override
    @Transactional
    public void save(Gato gato) {
        gatoDao.save(gato);
    }

    @Override
    @Transactional
    public Gato findById(Long id) {
        return gatoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Gato gato) {
        gatoDao.delete(gato);
    }

    @Override
    @Transactional
    public void adoptarGato(Long idGato, Long idCliente) {
        if (idGato == null || idCliente == null) {
            throw new IllegalArgumentException("Los IDs de gato y cliente no pueden ser nulos");
        }

        Optional<Gato> optionalGato = gatoDao.findById(idGato);

        if (optionalGato.isPresent()) {
            Gato gato = optionalGato.get();

            GatoAdoptado gatoAdoptado = new GatoAdoptado();
            gatoAdoptado.setIdGato(gato.getIdGato());
            gatoAdoptado.setNombre(gato.getNombre());
            gatoAdoptado.setFoto(gato.getFoto());
            gatoAdoptado.setColor(gato.getColor());
            gatoAdoptado.setRaza(gato.getRaza());
            gatoAdoptado.setCaracter(gato.getCaracter());
            gatoAdoptado.setInformacionMedica(gato.getInformacionMedica() != null ? gato.getInformacionMedica() : "Sin información médica");
            gatoAdoptado.setEnfermedades(gato.getEnfermedades() != null ? gato.getEnfermedades() : "Sin enfermedades");
            gatoAdoptado.setCastrado(gato.getCastrado() != null ? gato.getCastrado() : false);
            gatoAdoptado.setFechaAdopcion(LocalDate.now());

            gatoAdoptado.setIdPropietario(idCliente);

            Optional<Usuario> optionalPropietario = usuarioDao.findById(idCliente);
            if (optionalPropietario.isPresent()) {
                Usuario propietario = optionalPropietario.get();
                gatoAdoptado.setNombrePropietario(propietario.getUsername());
            } else {
                throw new RuntimeException("Propietario no encontrado con ID: " + idCliente);
            }

            gatoDao.save(gatoAdoptado);
            gatoDao.delete(gato);
        } else {
            throw new RuntimeException("Gato no encontrado con ID: " + idGato);
        }
    }
}