package com.example.demo.models.services;

import com.example.demo.models.dao.IGatoDao;
import com.example.demo.models.entities.Gato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
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
}