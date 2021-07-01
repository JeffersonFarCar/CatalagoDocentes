package com.demo.catalagodocentes.service;

import com.demo.catalagodocentes.model.dto.PostulanteDTO;
import com.demo.catalagodocentes.model.entity.Postulante;
import com.demo.catalagodocentes.model.entity.Usuario;
import com.demo.catalagodocentes.repository.IPostulanteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Service
public class PostulanteService {
    private IPostulanteRepository postulanteRepository;
    public PostulanteService(IPostulanteRepository _postulante) {
        postulanteRepository = _postulante;
    }
    @Transactional(readOnly = false)
    public Postulante createPostulante(@Valid PostulanteDTO postulanteDTO){
        Postulante postulante = new Postulante();
        postulante.setIdPostulante(postulanteDTO.getIdPostulante());
        postulante.setUsuario(new Usuario(
                postulanteDTO.getUsuarioDTO().getIdUsuario(),
                postulanteDTO.getUsuarioDTO().getNombre(),
                postulanteDTO.getUsuarioDTO().getApellido(),
                postulanteDTO.getUsuarioDTO().getEmail(),
                postulanteDTO.getUsuarioDTO().getPassword()
        ));
        return postulanteRepository.save(postulante);
    }

    @Transactional(readOnly = true)
    public Postulante readPostulante(Long idPostulante){
        Postulante postulante = postulanteRepository.findById(idPostulante).get();
        return postulante;
    }

    public List<Postulante> getPostulantes(){
        List<Postulante> postulantes = postulanteRepository.findAll();
        return postulantes;
    }
}
