package com.salesianostriana.dam.monumentos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {


    @Id
    @GeneratedValue
    private Long id;

    private String codigoPais;
    private String pais;
    private String ciudad;
    private String loc;
    private String nombre;
    private String descripcion;
    private String urlImagen;

}
