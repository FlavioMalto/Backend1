package com.malto.Aula19.services;

import com.malto.Aula19.domain.Paciente;

import java.util.List;

public interface PacienteInterface {

    List<Paciente> listarPaciente();

    Paciente pacientePorEmail(String email);

}
