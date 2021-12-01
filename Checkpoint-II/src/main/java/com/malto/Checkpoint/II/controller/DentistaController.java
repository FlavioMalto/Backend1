package com.malto.Checkpoint.II.controller;

import com.malto.Checkpoint.II.model.Dentista;
import com.malto.Checkpoint.II.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @GetMapping
    public ResponseEntity<List<Dentista>> getDentistas(){
        return ResponseEntity.ok(dentistaService.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> getDentistaId(@PathVariable Integer id){
        return ResponseEntity.ok(dentistaService.read(id));
    }

    @PostMapping
    public ResponseEntity<Dentista> postDentista(@RequestBody Dentista dentista){
        return ResponseEntity.ok(dentistaService.create(dentista));
    }

    @PutMapping("/{id}/{email}")
    public ResponseEntity<Dentista> putDentista(@PathVariable Integer id, @PathVariable String email){
        Dentista dentista = dentistaService.update(id, email);
        if(dentista == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(dentista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDentista(@PathVariable Integer id){
        String resposta = dentistaService.delete(id);
        if(resposta == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(resposta);
    }

}
