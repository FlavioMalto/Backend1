package com.malto.Aula29.persistence.repository;

import com.malto.Aula29.persistence.entities.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<TimeEntity, Integer> {
}
