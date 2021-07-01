package com.demo.catalagodocentes.repository;

//Queries

import com.demo.catalagodocentes.model.entity.Evaluador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvaluadorRepository extends JpaRepository<Evaluador, Long>{
}
