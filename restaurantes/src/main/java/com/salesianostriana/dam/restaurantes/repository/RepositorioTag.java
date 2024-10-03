package com.salesianostriana.dam.restaurantes.repository;

import com.salesianostriana.dam.restaurantes.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTag extends JpaRepository<Tag, String>{
}
