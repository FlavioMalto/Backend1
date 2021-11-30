package com.malto.Checkpoint.II.service;

import com.malto.Checkpoint.II.model.Dentista;
import com.malto.Checkpoint.II.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository dentistaRepository;

    public Dentista create(Dentista dentista){
        return dentistaRepository.save(dentista);
    }

    public List<Dentista> readAll(){
        return dentistaRepository.findAll();
    }

    public Dentista read(Integer id){
        return dentistaRepository.findById(id).get();
    }

    public Dentista update()

}
