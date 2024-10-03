package com.salesianostriana.dam.restaurantes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="tags")
public class Tag {

    @Id
    private String nombreTag;

    @Column
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Restaurante> restaurantesEnLosQueEsta;

}
