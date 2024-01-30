package com.example.demo.models.services;

import com.example.demo.models.dao.IGatoDao;
import com.example.demo.models.entities.Gato;
import com.example.demo.models.entities.GatoAdoptado;
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
    public void adoptarGato(Long idGato) {
        if (idGato == null) {
            throw new IllegalArgumentException("El ID de gato no puede ser nulo");
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
            gatoAdoptado.setInformacionMedica(gato.getInformacionMedica() != null ? gato.getInformacionMedica() : "Sin informacion medica");
            gatoAdoptado.setEnfermedades(gato.getEnfermedades() != null ? gato.getEnfermedades() : "Sin enfermedades");
            gatoAdoptado.setCastrado(gato.getCastrado() != null ? gato.getCastrado() : false);
            gatoAdoptado.setFechaAdopcion(LocalDate.now());

            gatoDao.save(gatoAdoptado);
            gatoDao.delete(gato);
        } else {
            throw new RuntimeException("Gato no encontrado con ID: " + idGato);
        }
    }

//    @Override
//    @Transactional
//    public void adoptarGato(Long idGato) {
//        if (idGato == null) {
//            throw new IllegalArgumentException("El ID de gato no puede ser nulo");
//        }
//
//        Optional<Gato> optionalGato = gatoDao.findById(idGato);
//
//        if (optionalGato.isPresent()) {
//            Gato gato = optionalGato.get();
//            System.out.println(gato.getNombre());
//            System.out.println(gato.getIdGato());
//            System.out.println(gato.getCastrado());
//            System.out.println(gato.getFoto());
//            System.out.println("Informacion Medica del Gato Original: " + gato.getInformacionMedica());
//            System.out.println("Enfermedades del Gato Original: " + gato.getEnfermedades());
//
//
//            // Validar que el ID de propietario no sea nulo
////            if (idPropietario == null) {
////                throw new IllegalArgumentException("El ID de propietario no puede ser nulo");
////            }
//
//            GatoAdoptado gatoAdoptado = new GatoAdoptado();
//            gatoAdoptado.setIdGato(gato.getIdGato());
//            gatoAdoptado.setNombre(gato.getNombre());
//            gatoAdoptado.setFoto(gato.getFoto());
//            gatoAdoptado.setColor(gato.getColor());
//            gatoAdoptado.setRaza(gato.getRaza());
//            gatoAdoptado.setCaracter(gato.getCaracter());
//            gatoAdoptado.setInformacionMedica(gato.getInformacionMedica() != null ? gato.getInformacionMedica() : "Sin informacion medica");
//            gatoAdoptado.setEnfermedades(gato.getEnfermedades() != null ? gato.getEnfermedades() : "Sin enfermedades");
//            gatoAdoptado.setCastrado(gato.getCastrado() != null ? gato.getCastrado() : false);
//            gatoAdoptado.setFechaAdopcion(LocalDate.now());
//
//            gatoDao.save(gatoAdoptado);
//            System.out.println(gato.getNombre());
//            System.out.println(gato.getIdGato());
//            System.out.println(gato.getCastrado());
//            System.out.println(gato.getFoto());
//            System.out.println("Informacion Medica del Gato Original: " + gato.getInformacionMedica());
//            System.out.println("Enfermedades del Gato Original: " + gato.getEnfermedades());
//            System.out.println(gato.getNombre());
//            System.out.println(gato.getIdGato());
//            System.out.println(gato.getCastrado());
//            System.out.println(gato.getFoto());
//            System.out.println("Informacion Medica del Gato Original: " + gato.getInformacionMedica());
//            System.out.println("Enfermedades del Gato Original: " + gato.getEnfermedades());
//            System.out.println(gato.getNombre());
//            System.out.println(gato.getIdGato());
//            System.out.println(gato.getCastrado());
//            System.out.println(gato.getFoto());
//            System.out.println("Informacion Medica del Gato Original: " + gato.getInformacionMedica());
//            System.out.println("Enfermedades del Gato Original: " + gato.getEnfermedades());
//            System.out.println(gato.getNombre());
//            System.out.println(gato.getIdGato());
//            System.out.println(gato.getCastrado());
//            System.out.println(gato.getFoto());
//            System.out.println("Informacion Medica del Gato Original: " + gato.getInformacionMedica());
//            System.out.println("Enfermedades del Gato Original: " + gato.getEnfermedades());
//
//
//            gatoDao.delete(gato);
//
//        } else {
//            throw new RuntimeException("Gato no encontrado con ID: " + idGato);
//        }
//    }
}