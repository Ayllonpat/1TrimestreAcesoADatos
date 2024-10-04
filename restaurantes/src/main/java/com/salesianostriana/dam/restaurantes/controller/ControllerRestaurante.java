package com.salesianostriana.dam.restaurantes.controller;

import com.salesianostriana.dam.restaurantes.model.Restaurante;
import com.salesianostriana.dam.restaurantes.service.ServicioRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ControllerRestaurante {

    @Autowired
    private ServicioRestaurante restauranteService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Restaurante>>mostrarLista(){
        return new ResponseEntity<>(restauranteService.findAllRestaurantes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> mostrarRestaurantePorId(@PathVariable("id")Long id){
        Optional<Restaurante> optionalRestaurante = restauranteService.findById(id);
        if (optionalRestaurante.isPresent()) {
            Restaurante restaurante = optionalRestaurante.get();
            return new ResponseEntity<Restaurante>(restaurante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<Restaurante> crear(@RequestBody Restaurante restaurante) {

        return new ResponseEntity<>(restauranteService.guardarRestaurante(restaurante), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> editar(@PathVariable Long id, @RequestBody Restaurante cambio) {

        Optional<Restaurante> optionalRestaurante = restauranteService.findById(id);

        if(optionalRestaurante.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Restaurante>(restauranteService.editarRestaurante(id, cambio), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id) {

        if (restauranteService.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        restauranteService.deleteByIdRestaurante(id);

        return ResponseEntity.noContent().build();
    }
}
