package com.demo.catalagodocentes.repository;

//Queries

import com.demo.catalagodocentes.model.entity.Postulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostulanteRepository extends JpaRepository <Postulante, Long>{

}
