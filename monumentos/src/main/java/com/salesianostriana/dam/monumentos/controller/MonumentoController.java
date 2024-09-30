package com.salesianostriana.dam.monumentos.controller;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentoRepositorio;
import com.salesianostriana.dam.monumentos.service.MonumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monumento")
public class MonumentoController {

    @Autowired
    private MonumentoService monumentoService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Monumento>>mostrarLista(){
        return new ResponseEntity<>(monumentoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<List<Monumento>>mostrarListaPorId(@PathVariable("id")Long id){
        return new ResponseEntity<List<Monumento>>(monumentoService.findById(id), HttpStatus.OK);
    }


}
