package com.demo.catalagodocentes.repository;

//Queries

import com.demo.catalagodocentes.model.entity.TipoEvaluador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEvaluadorRepository extends JpaRepository<TipoEvaluador, Long>{
}
