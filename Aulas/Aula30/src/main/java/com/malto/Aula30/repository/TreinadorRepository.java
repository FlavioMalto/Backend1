package com.malto.Aula30.repository;

import com.malto.Aula30.model.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface TreinadorRepository extends JpaRepository<Treinador, Integer> {
}
