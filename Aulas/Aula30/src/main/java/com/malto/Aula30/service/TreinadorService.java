package com.malto.Aula30.service;

import com.malto.Aula30.model.Treinador;
import com.malto.Aula30.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinadorService {

    @Autowired
    private TreinadorRepository treinadorRepository;

    public Treinador insert(Treinador treinador){
        return treinadorRepository.save(treinador);
    }

}
