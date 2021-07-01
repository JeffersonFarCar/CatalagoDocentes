package com.demo.catalagodocentes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
//Mapping ORM
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Postulante {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPostulante;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;
}
