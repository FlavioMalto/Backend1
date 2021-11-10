package com.malto.Aula18.service;

import com.malto.Aula18.domain.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorServer implements ProfessorInterface{

    @Override
    public List<Professor> listarProfessores() {
        List<Professor> listaProfessores = new ArrayList<>();

        listaProfessores.add(new Professor("Roberto", 32, "Matemática"));
        listaProfessores.add(new Professor("Julia", 28, "História"));
        listaProfessores.add(new Professor("Robson", 45, "Física"));


        return listaProfessores;
    }
}
