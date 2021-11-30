package com.malto.Aula26.service;


import com.malto.Aula26.dao.FilmeDAO;
import com.malto.Aula26.model.Filme;
import com.malto.Aula26.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public Map<Integer, Filme> buscarFilmes(){
       return repository.selectAll();
    }

    public Map<Integer, Filme> buscarFilmePorId(Integer id){
        return repository.select(id);
    }

    public String deletarFilme(Integer id){

        repository.delete(id);

        return "Deletado com sucesso!";
    }

    public Map<Integer, Filme> criarFilme(FilmeDAO dao){

        Filme filme = new Filme(dao.getNome(), dao.getClassificacao(), dao.getGenero(), dao.getDistribuidora());

        return repository.create(filme);

    }

    public Map<Integer, Filme> editarFilme(FilmeDAO dao){

        Filme filme = new Filme(dao.getNome(), dao.getClassificacao(), dao.getGenero(), dao.getDistribuidora());

        return repository.update(filme, dao.getId());

    }

}
