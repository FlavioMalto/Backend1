package com.malto.Aula29.persistence.repository;

import com.malto.Aula29.persistence.entities.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorEntity, Integer> {
}
