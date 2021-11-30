package com.malto.Aula29.service;

import com.malto.Aula29.persistence.entities.JogadorEntity;
import com.malto.Aula29.persistence.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public List<JogadorEntity> buscarTodos(){
        return jogadorRepository.findAll();
    }

    public JogadorEntity buscarPorId(Integer id){
        return jogadorRepository.findById(id).get();
    }

    public JogadorEntity salvar(){
        return null;
    }

}
