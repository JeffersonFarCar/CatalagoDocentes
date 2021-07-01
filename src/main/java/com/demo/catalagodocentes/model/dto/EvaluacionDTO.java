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
public class EvaluacionDTO {
    @NotNull
    private Long idEvaluacion;
    @NotNull
    private PlazasDTO plazasDTO;
    @NotNull
    private PostulanteDTO postulanteDTO;
    @NotNull
    private Integer n1;
    @NotNull
    private Integer n2;
}
