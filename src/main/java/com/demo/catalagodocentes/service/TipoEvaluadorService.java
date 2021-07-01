package com.demo.catalagodocentes.service;

import com.demo.catalagodocentes.model.entity.TipoEvaluador;
import com.demo.catalagodocentes.repository.ITipoEvaluadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Service
public class TipoEvaluadorService {
    private ITipoEvaluadorRepository tipoEvaluadorRepository;
    public TipoEvaluadorService(ITipoEvaluadorRepository _tipoe){
        tipoEvaluadorRepository = _tipoe;
    }

    @Transactional(readOnly = true)
    public TipoEvaluador readTipoEvaluador(Long idTipoE){
        TipoEvaluador tipoEvaluador = tipoEvaluadorRepository.findById(idTipoE).get();
        return tipoEvaluador;
    }
}
