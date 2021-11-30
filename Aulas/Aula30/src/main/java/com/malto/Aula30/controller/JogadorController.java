package com.malto.Aula30.controller;

import com.malto.Aula30.dao.JogadorDAO;
import com.malto.Aula30.model.Jogador;
import com.malto.Aula30.service.JogadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private JogadorService jogadorService;

    @PostMapping
    public Jogador postJogador(@RequestBody JogadorDAO jogadorDAO){
        return jogadorService.insert(jogadorDAO);
    }

    @GetMapping("/{id}")
    public List<String> getJogadorPorTreinador(@PathVariable Integer id){
        return jogadorService.buscarPorTreinador(id);
    }

}
