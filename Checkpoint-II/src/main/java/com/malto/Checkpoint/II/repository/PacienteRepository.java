package com.malto.Checkpoint.II.repository;

import com.malto.Checkpoint.II.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
