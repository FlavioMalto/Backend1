package com.malto.Checkpoint.II.controller;

import com.malto.Checkpoint.II.dao.PacienteDAO;
import com.malto.Checkpoint.II.model.Paciente;
import com.malto.Checkpoint.II.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> postPaciente(@RequestBody PacienteDAO pacienteDAO){
        return ResponseEntity.ok(pacienteService.create(pacienteDAO));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getPacientes(){
        return ResponseEntity.ok(pacienteService.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteId(@PathVariable Integer id){
        return ResponseEntity.ok(pacienteService.read(id));
    }

    @PutMapping("/{id}/{email}")
    public ResponseEntity<Paciente> putPaciente(@PathVariable Integer id, @PathVariable String email){
        Paciente paciente = pacienteService.update(id, email);
        if(paciente == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Integer id){
        String resposta = pacienteService.delete(id);
        if(resposta == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(resposta);
    }

}
