package com.demo.catalagodocentes.repository;

import com.demo.catalagodocentes.model.entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICalificacionRepository extends JpaRepository<Calificacion, Long>{
}
