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
public class Evaluador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluador;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private TipoEvaluador tipoEvaluador;
}
