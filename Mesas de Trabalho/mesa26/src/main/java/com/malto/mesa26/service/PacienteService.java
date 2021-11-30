package com.malto.mesa26.service;

import com.malto.mesa26.dao.PacienteDAO;
import com.malto.mesa26.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PacienteService implements ServiceInterface<Paciente, PacienteDAO> {


    //chave integer pois será usado o id
    private static Map<Integer, Paciente> mapPaciente = new HashMap<>();


    @Override
    public Map<Integer, Paciente> buscar(){
        return mapPaciente;
    }

    @Override
    public void deletar(Integer id){
        mapPaciente.remove(id);
    }

    @Override
    public Paciente criar(PacienteDAO dao){

        Integer id = mapPaciente.size() + 1;

        mapPaciente.put(id, new Paciente(dao.getNome(), dao.getSobrenome(), dao.getEmail()));

        return mapPaciente.get(id);
    }

    @Override
    public Paciente editar(PacienteDAO dao){

        Paciente paciente = mapPaciente.get(dao.getId());

        paciente.setNome(dao.getNome());
        paciente.setSobrenome(dao.getSobrenome());
        paciente.setEmail(dao.getEmail());

        return paciente;
    }

}
