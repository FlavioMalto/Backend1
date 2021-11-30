package com.malto.Aula30.service;

import com.malto.Aula30.model.Equipe;
import com.malto.Aula30.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public Equipe insert(Equipe equipe){
        return equipeRepository.save(equipe);
    }

}
