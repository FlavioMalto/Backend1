package com.malto.mesa26.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Consulta {

    private Paciente paciente;
    private Dentista dentista;
    private Date dataConsulta;

    public Consulta(Paciente paciente, Dentista dentista, Date dataConsulta) {
        this.paciente = paciente;
        this.dentista = dentista;
        this.dataConsulta = dataConsulta;
    }
}
