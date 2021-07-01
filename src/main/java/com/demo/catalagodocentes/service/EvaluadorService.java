package com.demo.catalagodocentes.service;

import com.demo.catalagodocentes.model.dto.EvaluadorDTO;
import com.demo.catalagodocentes.model.entity.Evaluador;
import com.demo.catalagodocentes.model.entity.TipoEvaluador;
import com.demo.catalagodocentes.model.entity.Usuario;
import com.demo.catalagodocentes.repository.IEvaluadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Service
public class EvaluadorService {
    private IEvaluadorRepository evaluadorRepository;
    public EvaluadorService(IEvaluadorRepository _evaluador){
        evaluadorRepository = _evaluador;
    }
    @Transactional(readOnly = false)
    public Evaluador createEvaluador(@Valid EvaluadorDTO evaluadorDTO){
        Evaluador evaluador = new Evaluador();
        evaluador.setIdEvaluador(evaluadorDTO.getIdEvaluador());
        evaluador.setUsuario(new Usuario(
                evaluadorDTO.getUsuarioDTO().getIdUsuario(),
                evaluadorDTO.getUsuarioDTO().getNombre(),
                evaluadorDTO.getUsuarioDTO().getApellido(),
                evaluadorDTO.getUsuarioDTO().getEmail(),
                evaluadorDTO.getUsuarioDTO().getPassword()
        ));
        evaluador.setTipoEvaluador(new TipoEvaluador(
                evaluadorDTO.getTipoEvaluadorDTO().getIdTipo(),
                evaluadorDTO.getTipoEvaluadorDTO().getDescripcion()
        ));
        return evaluadorRepository.save(evaluador);
    }

    @Transactional(readOnly = true)
    public Evaluador readEvaluador(Long idEvaluador){
        Evaluador evaluador = evaluadorRepository.findById(idEvaluador).get();
        return evaluador;
    }

    public List<Evaluador> getEvaluadores(){
        List<Evaluador> evaluadores = evaluadorRepository.findAll();
        return evaluadores;
    }
}
