package com.demo.catalagodocentes.controller;

import com.demo.catalagodocentes.model.dto.*;
import com.demo.catalagodocentes.model.entity.Calificacion;
import com.demo.catalagodocentes.service.CalificacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/concurso/calificacion")
public class CalificacionRestController {

    private CalificacionService calificacionService;

    CalificacionRestController(CalificacionService service){
        calificacionService = service;
    }

    @PostMapping("/calificacion/create")
    Calificacion createCalificacion(@RequestBody CalificacionDTO calificacionDTO){
        return calificacionService.createCalificaion(calificacionDTO);
    }

    @GetMapping("/calificacion/list")
    List<CalificacionDTO> allCalificaciones(){
        return calificacionService.getCalificaciones().stream().map(calificacion -> {
            return CalificacionDTO.builder().
                    idC(calificacion.getIdC()).
                    evaluacionDTO(
                           new EvaluacionDTO(
                                   calificacion.getEvaluacion().getIdEvaluacion(),
                                   new PlazasDTO(
                                           calificacion.getEvaluacion().getPlazas().getIdPlaza(),
                                           new PostulanteDTO(
                                                   calificacion.getEvaluacion().getPlazas().getPostulante().getIdPostulante(),
                                                   new UsuarioDTO(
                                                           calificacion.getEvaluacion().getPlazas().getPostulante().getUsuario().getIdUsuario(),
                                                           calificacion.getEvaluacion().getPlazas().getPostulante().getUsuario().getNombre(),
                                                           calificacion.getEvaluacion().getPlazas().getPostulante().getUsuario().getApellido(),
                                                           calificacion.getEvaluacion().getPlazas().getPostulante().getUsuario().getEmail(),
                                                           calificacion.getEvaluacion().getPlazas().getPostulante().getUsuario().getPassword()
                                                   )
                                           ),
                                           calificacion.getEvaluacion().getPlazas().getDescripcion()
                                   ),
                                   new PostulanteDTO(
                                           calificacion.getEvaluacion().getPostulante().getIdPostulante(),
                                           new UsuarioDTO(
                                                   calificacion.getEvaluacion().getPostulante().getUsuario().getIdUsuario(),
                                                   calificacion.getEvaluacion().getPostulante().getUsuario().getNombre(),
                                                   calificacion.getEvaluacion().getPostulante().getUsuario().getApellido(),
                                                   calificacion.getEvaluacion().getPostulante().getUsuario().getEmail(),
                                                   calificacion.getEvaluacion().getPostulante().getUsuario().getPassword()
                                           )
                                   ),
                                   calificacion.getEvaluacion().getN1(),
                                   calificacion.getEvaluacion().getN2()
                           )
                    ).
                    evaluadorDTO(
                            new EvaluadorDTO(
                                    calificacion.getEvaluador().getIdEvaluador(),
                                    new UsuarioDTO(
                                            calificacion.getEvaluador().getUsuario().getIdUsuario(),
                                            calificacion.getEvaluador().getUsuario().getNombre(),
                                            calificacion.getEvaluador().getUsuario().getApellido(),
                                            calificacion.getEvaluador().getUsuario().getEmail(),
                                            calificacion.getEvaluador().getUsuario().getPassword()
                                    ),
                                    new TipoEvaluadorDTO(
                                            calificacion.getEvaluador().getTipoEvaluador().getIdTipo(),
                                            calificacion.getEvaluador().getTipoEvaluador().getDescripcion()
                                    )
                            )
                    ).
                    build();
        }).collect(Collectors.toList());
    }
}
