package com.malto.Checkpoint.II.service;

import com.malto.Checkpoint.II.model.Dentista;
import com.malto.Checkpoint.II.repository.DentistaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository dentistaRepository;

    private static final Logger logger = Logger.getLogger(DentistaService.class);

    public Dentista create(Dentista dentista){
        logger.info("Dentista criado com sucesso.");
        return dentistaRepository.save(dentista);
    }

    public List<Dentista> readAll(){
        logger.info("todos os dentistas foram selecionados.");
        return dentistaRepository.findAll();
    }

    public Dentista read(Integer id){
        logger.info(String.format("O dentista de id %s foi SELECIONADO.", id));
        return dentistaRepository.findById(id).get();
    }

    public Dentista update(Integer id, String email){
        if(dentistaRepository.existsById(id)){
            logger.info(String.format("O dentista de id %s foi EDITADO.", id));
            Dentista dentista = dentistaRepository.findById(id).get();
            dentista.setEmail(email);
            return create(dentista);
        }
        return null;
    }

    public String delete(Integer id){
        if(dentistaRepository.existsById(id)){
            logger.info(String.format("O dentista de id %s foi DELETADO", id));
            dentistaRepository.deleteById(id);
            return String.format("O dentista de id %s foi DELETADO.", id);
        }
        return null;
    }

}
