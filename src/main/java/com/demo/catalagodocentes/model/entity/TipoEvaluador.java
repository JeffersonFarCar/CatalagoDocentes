package com.demo.catalagodocentes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
//Mapping ORM
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TipoEvaluador {
    @Id
    private Long idTipo;
    private String descripcion;
}
