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
public class Plazas {
    @Id
    private Long idPlaza;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Postulante postulante;
    private String descripcion;
}
