package com.malto.Aula19.services;

import com.malto.Aula19.domain.Endereco;
import com.malto.Aula19.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class PacienteService implements PacienteInterface{
    @Override
    public List<Paciente> listarPaciente() {

        List<Paciente> lista = new ArrayList<>();

        lista.add(new Paciente(8169, "Maria", "Silva", "mariasilva@gmail.com",
                "98756211488", new Date(),
                new Endereco("Rua das Graças", "123", "São Paulo", "SP")));

        lista.add(new Paciente(9874, "José", "Gomez", "josegomez@gmail.com",
                "7894561235", new Date(),
                new Endereco("Rua Antonio Barbosa", "321", "Osasco", "SP")));

        lista.add(new Paciente(5612, "Jessica", "Barros", "jessicabarros@gmail.com",
                "587914652148", new Date(),
                new Endereco("Rua Olivia Souza", "123", "Barueri", "SP")));

        return lista;
    }

    @Override
    public Paciente pacientePorEmail(String email) {
        return new Paciente(2548, "Paciente", "Por Email",
                email, "8569577828", new Date(),
                new Endereco("Rua do paciente", "777", "Carapicuiba", "SP"));
    }
}
