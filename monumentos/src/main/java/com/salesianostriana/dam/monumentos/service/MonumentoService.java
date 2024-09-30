package com.salesianostriana.dam.monumentos.service;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonumentoService {

    @Autowired
    public MonumentoRepositorio monumentoRepositorio;

    public List<Monumento> findAll() {
        return monumentoRepositorio.findAll();
    }

    public Optional<Monumento> findById(Long id){
        return monumentoRepositorio.findById(id);
    }
}
