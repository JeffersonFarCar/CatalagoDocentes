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
    @NotBlank
    @Positive
    private Long idC;
    @NotBlank
    private EvaluacionDTO evaluacionDTO;
    @NotBlank
    private EvaluadorDTO evaluadorDTO;
    @NotBlank
    private Integer nota;
}
