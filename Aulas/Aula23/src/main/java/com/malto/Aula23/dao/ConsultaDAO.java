package com.malto.Aula23.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.malto.Aula23.model.Dentista;
import com.malto.Aula23.model.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class ConsultaDAO {

    private Integer id;
    private Paciente paciente;
    private Dentista dentista;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dataConsulta;

}
