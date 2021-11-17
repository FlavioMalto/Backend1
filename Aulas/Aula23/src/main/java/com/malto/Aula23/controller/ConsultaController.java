package com.malto.Aula23.controller;


import com.malto.Aula23.dao.ConsultaDAO;
import com.malto.Aula23.model.Consulta;
import com.malto.Aula23.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ConsultaController {

    //executando o springboot ele já inicia o consulta service
    //e já chama o construtor criando os modelos inseridos
    @Autowired
    private ConsultaService service;

    //retorna o responseEntity que trata o retorno da requisição http
    @GetMapping
    public ResponseEntity<Map<Integer, Consulta>> getConsultas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarConsulta());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConsulta(@PathVariable Integer id){
        service.deletarConsulta(id);

        //.ok = .status(HttpStatus.OK)
        return ResponseEntity.ok("Deletado com sucesso");
    }

    @PostMapping
    public ResponseEntity<Consulta> postConsulta(@RequestBody ConsultaDAO dao){
        Consulta consulta = service.criarConsulta(dao);

        if(consulta == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(consulta);
    }

    @PutMapping
    public ResponseEntity<Consulta> putConsulta(@RequestBody ConsultaDAO dao){
        //.status(200) = .status(HttpStatus.OK)
        return ResponseEntity.status(200).body(service.editarConsulta(dao));
    }

}
