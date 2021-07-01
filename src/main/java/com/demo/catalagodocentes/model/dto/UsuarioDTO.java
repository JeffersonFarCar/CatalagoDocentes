package com.demo.catalagodocentes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    @NotNull
    @Positive
    private Long idUsuario;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
