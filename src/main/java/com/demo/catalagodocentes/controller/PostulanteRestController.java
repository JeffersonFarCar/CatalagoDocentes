package com.demo.catalagodocentes.controller;

import com.demo.catalagodocentes.model.dto.PostulanteDTO;
import com.demo.catalagodocentes.model.dto.UsuarioDTO;
import com.demo.catalagodocentes.model.entity.Postulante;
import com.demo.catalagodocentes.service.PostulanteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/concurso/postulante")
public class PostulanteRestController {

    private PostulanteService postulanteService;

    PostulanteRestController(PostulanteService service){
        postulanteService = service;
    }

    @PostMapping("/postulante/create")
    Postulante createPostulante(@RequestBody PostulanteDTO postulanteDTO){
        return postulanteService.createPostulante(postulanteDTO);
    }

    @GetMapping("/postulante/list")
    List<PostulanteDTO> allPostulantes(){
        return postulanteService.getPostulantes().stream().map(postulante -> {
            return PostulanteDTO.builder().idPostulante(postulante.getIdPostulante()).
                    usuarioDTO(new UsuarioDTO(postulante.getUsuario().getIdUsuario(),
                            postulante.getUsuario().getNombre(),
                            postulante.getUsuario().getApellido(),
                            postulante.getUsuario().getEmail(),
                            postulante.getUsuario().getPassword())).
                    build();
        }).collect(Collectors.toList());
    }
}
