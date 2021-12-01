package com.malto.Checkpoint.II.service;

import com.malto.Checkpoint.II.dao.PacienteDAO;
import com.malto.Checkpoint.II.model.Dentista;
import com.malto.Checkpoint.II.model.Paciente;
import com.malto.Checkpoint.II.repository.DentistaRepository;
import com.malto.Checkpoint.II.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DentistaRepository dentistaRepository;

    private static final Logger logger = Logger.getLogger(PacienteService.class);

    public Paciente create(PacienteDAO pacienteDAO){
        logger.info("Paciente criado com sucesso.");
        Dentista dentista = dentistaRepository.getById(pacienteDAO.getDentistaId());

        Paciente paciente = new Paciente(pacienteDAO.getNome(), pacienteDAO.getSobrenome(),
                pacienteDAO.getEmail(), dentista);

        return pacienteRepository.save(paciente);
    }

    public List<Paciente> readAll(){
        return pacienteRepository.findAll();
    }

    public Paciente read(Integer id){
        logger.info(String.format("O Paciente de id %s foi SELECIONADO.", id));
        return pacienteRepository.findById(id).get();
    }

    public Paciente update(Integer id, String email){
        if(pacienteRepository.existsById(id)){
            logger.info(String.format("O paciente de id %s foi EDITADO.", id));
            Paciente paciente = pacienteRepository.findById(id).get();

            paciente.setEmail(email);

            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public String delete(Integer id){
        if(pacienteRepository.existsById(id)){
            logger.info(String.format("O paciente de id %s foi DELETADO", id));
            pacienteRepository.deleteById(id);
            return String.format("O paciente de id %s foi DELETADO.", id);
        }
        return null;
    }



}
