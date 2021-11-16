package com.malto.Aula21.controller;


import com.malto.Aula21.dao.PokemonDAO;
import com.malto.Aula21.domain.Pokemon;
import com.malto.Aula21.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    //buscar metodos de criação, edição e lista dentro do service
    @Autowired
    private PokemonService service;

    @GetMapping
    public Map<Integer, Pokemon> getPokemons(){
        return service.buscarPokemon();
    }

    @GetMapping("id")
    public Pokemon getPokemonId()

    //criar endereço para criação de pokemons. recebe como parâmetro ao que stá no corpo do pokemon DAO
    @PostMapping
    public Pokemon postPokemon(@RequestBody PokemonDAO dao) {
        return service.criarPokemon(dao);
    }

    //metodo de editar no HTTP
    @PutMapping
    public Pokemon putPokemon(@RequestBody PokemonDAO dao){
        return service.editarPokemon(dao);
    }

    @DeleteMapping
    public String deletePokemon(@RequestBody PokemonDAO dao){
        return service.deletarPokemon(dao);
    }

}
