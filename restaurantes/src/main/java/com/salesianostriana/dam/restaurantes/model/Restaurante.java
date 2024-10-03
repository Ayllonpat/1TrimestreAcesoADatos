package com.salesianostriana.dam.restaurantes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="restaurantes")
public class Restaurante {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nombreRestaurante;

    @Column(nullable = false)
    private String direccionRestaurante;

    @Column(nullable = false)
    private String localizacionRestaurante;

    @Column(nullable = false, length = 2000)
    private String descripcionRestaurante;

    @Column
    @ManyToMany(mappedBy = "restaurantes", fetch = FetchType.EAGER)
    private List<Tag> tags;

    @Column(nullable = false)
    private String urlRestaurante;

}
