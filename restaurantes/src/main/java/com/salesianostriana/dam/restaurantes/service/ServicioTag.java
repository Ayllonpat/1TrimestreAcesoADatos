package com.salesianostriana.dam.restaurantes.service;

import com.salesianostriana.dam.restaurantes.model.Tag;
import com.salesianostriana.dam.restaurantes.repository.RepositorioTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioTag {

    @Autowired
    public RepositorioTag repositorioTag;

    public List<Tag> findAllTags(){
        return repositorioTag.findAll();
    }

    public Optional<Tag> findById(String id){
        return repositorioTag.findById(id);
    }

    public Tag guardarTag(Tag tag) {
        return repositorioTag.save(tag);
    }

    public Tag editarTag(String id, Tag edicionTag) {

        Tag antTag = repositorioTag.findById(id).orElse(null);

        if(antTag != null){

            antTag.setNombreTag(edicionTag.getNombreTag());

            return repositorioTag.save(antTag);

        }
        return null;
    }

    public void deleteByIdTag(String id) {

        repositorioTag.deleteById(id);
    }


}
