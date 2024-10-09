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
@Table(name="tags")
public class Tag {

    @Id
    private String nombreTag;

    @ManyToMany(mappedBy = "tags",
            fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties("tags")
    @Builder.Default
    private List<Restaurante> bares = new ArrayList<>();

}
