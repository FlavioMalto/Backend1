package com.malto.mesa26.controller;

import com.malto.mesa26.dao.PacienteDAO;
import com.malto.mesa26.model.Paciente;
import com.malto.mesa26.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/paciente")
public class PacienteController implements ControllerInterface<Paciente, PacienteDAO> {

    @Autowired
    private PacienteService pacienteService;

    @Override
    public ResponseEntity<Map<Integer, Paciente>> getMethod() {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.buscar());
    }

    @Override
    public ResponseEntity<String> deleteMethod(Integer id) {
        pacienteService.deletar(id);

        //.ok = .status(HttpStatus.OK)
        return ResponseEntity.ok("Deletado com sucesso");
    }

    @Override
    public ResponseEntity<Paciente> postMethod(PacienteDAO dao) {
        Paciente paciente = pacienteService.criar(dao);

        if(paciente == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(paciente);
    }

    @Override
    public ResponseEntity<Paciente> putMethod(PacienteDAO dao) {
        //.status(200) = .status(HttpStatus.OK)
        return ResponseEntity.status(200).body(pacienteService.editar(dao));
    }
}
