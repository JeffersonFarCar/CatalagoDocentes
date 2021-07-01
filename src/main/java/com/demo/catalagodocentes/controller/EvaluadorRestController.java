package com.demo.catalagodocentes.controller;

import com.demo.catalagodocentes.model.dto.EvaluadorDTO;
import com.demo.catalagodocentes.model.dto.TipoEvaluadorDTO;
import com.demo.catalagodocentes.model.dto.UsuarioDTO;
import com.demo.catalagodocentes.model.entity.Evaluador;
import com.demo.catalagodocentes.service.EvaluadorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/concurso/evaluador")
public class EvaluadorRestController {

    private EvaluadorService evaluadorService;

    EvaluadorRestController(EvaluadorService service){
        evaluadorService = service;
    }

    @PostMapping("/evaluador/create")
    Evaluador createEvaluador(@RequestBody EvaluadorDTO evaluadorDTO){
        return evaluadorService.createEvaluador(evaluadorDTO);
    }

    @GetMapping("/evaluador/list")
    List<EvaluadorDTO> allEvaluadores(){
        return evaluadorService.getEvaluadores().stream().map(evaluador -> {
            return EvaluadorDTO.builder().idEvaluador(evaluador.getIdEvaluador()).
                    tipoEvaluadorDTO(new TipoEvaluadorDTO(
                            evaluador.getTipoEvaluador().getIdTipo(),
                            evaluador.getTipoEvaluador().getDescripcion()
                    )).
                    usuarioDTO(new UsuarioDTO(
                            evaluador.getUsuario().getIdUsuario(),
                            evaluador.getUsuario().getNombre(),
                            evaluador.getUsuario().getApellido(),
                            evaluador.getUsuario().getEmail(),
                            evaluador.getUsuario().getPassword()
                    )).build();
        }).collect(Collectors.toList());
    }
}
