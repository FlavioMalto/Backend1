package com.malto.Aula21.service;

import com.malto.Aula21.dao.PokemonDAO;
import com.malto.Aula21.domain.Pokemon;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PokemonService {

    private static Map<Integer, Pokemon> flyweight = new HashMap<>();

    public Map<Integer, Pokemon> buscarPokemon(){
        return flyweight;
    }

    public Pokemon criarPokemon(PokemonDAO dao){

        //ve o tamanho do flyweight e adiciona 1 para gerar novo id.
        Integer id = flyweight.size() + 1;

        //cria um pokemon usando os dados vindos do front end
        Pokemon pokemon = new Pokemon(dao.getNome(), dao.getTipo(), dao.getPokedex(), dao.getHabilidades());

        //adiciona o pokemon ao map flyweight
        flyweight.put(id, pokemon);

        //retorna o pokemon pelo id
        return flyweight.get(id);
    }

    public Pokemon editarPokemon(PokemonDAO dao) {

        //irá pegar o pokemon já criado pelo id
        Pokemon pokemon = flyweight.get(dao.getId());

        //para mudar as informações utilizamos o set para o objeto com o get do dao vindo do front end
        pokemon.setTipo(dao.getTipo());
        pokemon.setHabilidades(dao.getHabilidades());

        return pokemon;

    }

    public String deletarPokemon(PokemonDAO dao) {

        flyweight.remove(dao.getId());

        return "Pokemon Deletado!";
    }

    public Pokemon buscarPokemonId(PokemonDAO dao) {

        Pokemon pokemon = flyweight.get(dao.getId());

        return pokemon;
    }


}
