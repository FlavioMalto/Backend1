package com.malto.mesa25.controller;


import com.malto.mesa25.dao.ConsultaDAO;
import com.malto.mesa25.model.Consulta;
import com.malto.mesa25.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/consulta")
public class ConsultaController implements ControllerInterface<Consulta, ConsultaDAO> {

    //executando o springboot ele já inicia o consulta service
    //e já chama o construtor criando os modelos inseridos
    @Autowired
    private ConsultaService service;

    //retorna o responseEntity que trata o retorno da requisição http

    @Override
    public ResponseEntity<Map<Integer, Consulta>> getMethod(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar());
    }

    @Override
    public ResponseEntity<String> deleteMethod(Integer id){
        service.deletar(id);

        //.ok = .status(HttpStatus.OK)
        return ResponseEntity.ok("Deletado com sucesso");
    }

    @Override
    public ResponseEntity<Consulta> postMethod(ConsultaDAO dao){
        Consulta consulta = service.criar(dao);

        if(consulta == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(consulta);
    }

    @Override
    public ResponseEntity<Consulta> putMethod(ConsultaDAO dao){
        //.status(200) = .status(HttpStatus.OK)
        return ResponseEntity.status(200).body(service.editar(dao));
    }

}
