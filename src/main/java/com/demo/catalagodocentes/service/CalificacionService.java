package com.demo.catalagodocentes.service;

import com.demo.catalagodocentes.model.dto.CalificacionDTO;
import com.demo.catalagodocentes.model.entity.*;
import com.demo.catalagodocentes.model.entity.Calificacion;
import com.demo.catalagodocentes.repository.ICalificacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Service
public class CalificacionService {
    private ICalificacionRepository calificacionRepository;
    public CalificacionService(ICalificacionRepository _calificacion){
        calificacionRepository = _calificacion;
    }
    @Transactional(readOnly = false)
    public Calificacion createCalificaion(@Valid CalificacionDTO calificacionDTO){
        Calificacion calificacion = new Calificacion();
        calificacion.setEvaluacion(new Evaluacion(
                calificacionDTO.getEvaluacionDTO().getIdEvaluacion(),
                new Plazas(
                        calificacionDTO.getEvaluacionDTO().getPlazasDTO().getIdPlaza(),
                        new Postulante(
                                calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getIdPostulante(),
                                new Usuario(
                                        calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getUsuarioDTO().getIdUsuario(),
                                        calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getUsuarioDTO().getNombre(),
                                        calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getUsuarioDTO().getApellido(),
                                        calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getUsuarioDTO().getEmail(),
                                        calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getUsuarioDTO().getPassword()
                                )
                        ),
                        calificacionDTO.getEvaluacionDTO().getPlazasDTO().getDescripcion()
                ),
                new Postulante(
                        calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getIdPostulante(),
                        new Usuario(
                                calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getUsuarioDTO().getIdUsuario(),
                                calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getUsuarioDTO().getNombre(),
                                calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getUsuarioDTO().getApellido(),
                                calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getUsuarioDTO().getEmail(),
                                calificacionDTO.getEvaluacionDTO().getPlazasDTO().getPostulanteDTO().getUsuarioDTO().getPassword()
                        )
                ),
                calificacionDTO.getEvaluacionDTO().getN1(),
                calificacionDTO.getEvaluacionDTO().getN2()
        ));
        calificacion.setEvaluador(new Evaluador(
                calificacionDTO.getEvaluadorDTO().getIdEvaluador(),
                new Usuario(
                        calificacionDTO.getEvaluadorDTO().getUsuarioDTO().getIdUsuario(),
                        calificacionDTO.getEvaluadorDTO().getUsuarioDTO().getNombre(),
                        calificacionDTO.getEvaluadorDTO().getUsuarioDTO().getApellido(),
                        calificacionDTO.getEvaluadorDTO().getUsuarioDTO().getEmail(),
                        calificacionDTO.getEvaluadorDTO().getUsuarioDTO().getPassword()
                ),
                new TipoEvaluador(
                        calificacionDTO.getEvaluadorDTO().getTipoEvaluadorDTO().getIdTipo(),
                        calificacionDTO.getEvaluadorDTO().getTipoEvaluadorDTO().getDescripcion()
                )
        ));
        calificacion.setNota(calificacionDTO.getNota());
        return calificacionRepository.save(calificacion);
    }

    @Transactional(readOnly = true)
    public Calificacion readCalificacion(Long idCalificacion){
        Calificacion calificacion = calificacionRepository.findById(idCalificacion).get();
        return calificacion;
    }

    public List<Calificacion> getCalificaciones(){
        List<Calificacion> calificaciones = calificacionRepository.findAll();
        return calificaciones;
    }
}
