package com.demo.catalagodocentes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalificacionDTO {
    @NotNull
    private Long idC;
    @NotNull
    private EvaluacionDTO evaluacionDTO;
    @NotNull
    private EvaluadorDTO evaluadorDTO;
    @NotNull
    private Integer nota;
}
