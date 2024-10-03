package com.salesianostriana.dam.restaurantes.service;

import com.salesianostriana.dam.restaurantes.model.Restaurante;
import com.salesianostriana.dam.restaurantes.model.Tag;
import com.salesianostriana.dam.restaurantes.repository.RepositorioRestaurante;
import com.salesianostriana.dam.restaurantes.repository.RepositorioTag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioRestaurante {

    @Autowired
    public RepositorioRestaurante repositorioRestaurante;

    @Autowired
    public RepositorioTag repositorioTag;

    public List<Restaurante> findAllRestaurantes(){
        return repositorioRestaurante.findAll();
    }

    public Optional<Restaurante> findById(Long id){
        return repositorioRestaurante.findById(id);
    }


    public Restaurante guardarRestaurante(Restaurante Restaurante, Tag tag) {

        return repositorioRestaurante.save(Restaurante);
    }

    public Restaurante editarRestaurante(Long id, Restaurante edicionRestaurante) {

        Restaurante antRestaurante = repositorioRestaurante.findById(id).orElse(null);

        if(antRestaurante != null){

            antRestaurante.setNombreRestaurante(edicionRestaurante.getNombreRestaurante());
            antRestaurante.setLocalizacionRestaurante(edicionRestaurante.getLocalizacionRestaurante());
            antRestaurante.setDescripcionRestaurante(edicionRestaurante.getDescripcionRestaurante());
            antRestaurante.setDireccionRestaurante(edicionRestaurante.getDireccionRestaurante());
            antRestaurante.setUrlRestaurante(edicionRestaurante.getUrlRestaurante());
            antRestaurante.setTags(edicionRestaurante.getTags());

            return repositorioRestaurante.save(antRestaurante);

        }
        return null;
    }

    public void deleteByIdRestaurante(Long id) {

        repositorioRestaurante.deleteById(id);
    }

}
