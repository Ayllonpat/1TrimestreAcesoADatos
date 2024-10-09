package com.salesianostriana.dam.restaurantes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @ManyToMany
    @JoinTable(name = "bar_tag",
            joinColumns = @JoinColumn(name = "bar_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties("bares")
    @Builder.Default
    private List<Tag> tags = new ArrayList<>();

    @Column(nullable = false)
    private String urlRestaurante;

}
