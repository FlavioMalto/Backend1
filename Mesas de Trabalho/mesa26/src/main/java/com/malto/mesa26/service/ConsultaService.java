package com.malto.mesa26.service;


import com.malto.mesa26.dao.ConsultaDAO;
import com.malto.mesa26.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsultaService implements ServiceInterface<Consulta, ConsultaDAO>{

    @Autowired
    public PacienteService pacienteService;
    public DentistaService dentistaService;

    //chave inteiro será criado id na criação do map
    private static Map<Integer, Consulta> mapConsulta = new HashMap<>();


    @Override
    public Map<Integer, Consulta> buscar(){
        return mapConsulta;
    }

    @Override
    public void deletar(Integer id){
        mapConsulta.remove(id);
    }

    @Override
    public Consulta criar(ConsultaDAO dao){

//        if(!dentistaService.buscar().containsKey(dao.getDentista().getCredencial())
//                || !pacienteService.buscar().containsKey(dao.getPaciente().getEmail())){
//            return null;
//        }

        Integer id = mapConsulta.size() + 1;

        mapConsulta.put(id, new Consulta(dao.getPaciente(), dao.getDentista(), dao.getDataConsulta()));

        return mapConsulta.get(id);
    }

    @Override
    public Consulta editar(ConsultaDAO dao){

        Consulta consulta = mapConsulta.get(dao.getId());

        consulta.setDataConsulta(dao.getDataConsulta());

        return consulta;
    }

}
