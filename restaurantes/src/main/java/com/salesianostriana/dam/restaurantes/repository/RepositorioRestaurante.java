package com.salesianostriana.dam.restaurantes.repository;

import com.salesianostriana.dam.restaurantes.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRestaurante extends JpaRepository<Restaurante, Long> {
}
