package com.malto.Aula22.controller;


import com.malto.Aula22.dao.DentistaDAO;
import com.malto.Aula22.domain.Dentista;
import com.malto.Aula22.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("dentista")
public class DentistaController {

    @Autowired
    private DentistaService service;

    @GetMapping("listarDentista")
    public Map<Integer, Dentista> getDentistas() {
        return service.listarDentistas();
    }

    @GetMapping("buscarDentista/{id}")
    public Dentista getDentistaId(@PathVariable ("id") Integer id) {
        return service.buscarDentista(id);
    }

    @PostMapping
    public Dentista postDentista(@RequestBody DentistaDAO dentistaDAO) {
        return service.registrarDentista(dentistaDAO);
    }

    @PutMapping
    public Dentista putDentista(@RequestBody DentistaDAO dentistaDAO) {
        return service.atualizarDentista(dentistaDAO);
    }

    @DeleteMapping("deletarDentista/{id}")
    public String deleteDentista(@PathVariable ("id") Integer id) {
        return service.deletarDentista(id);
    }

}
