package com.malto.Aula33.service;

import com.malto.Aula33.dao.PartidaDAO;
import com.malto.Aula33.enums.Status;
import com.malto.Aula33.model.Partida;
import com.malto.Aula33.model.Time;
import com.malto.Aula33.repository.PartidaRepository;
import com.malto.Aula33.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private TimeRepository timeRepository;

    public Partida createPartida(PartidaDAO partidaDAO){

        Partida partida = new Partida();

        Optional<Time> timeLocal = timeRepository.findById(partidaDAO.getIdTimeLocal());
        Optional<Time> timeVisitante = timeRepository.findById(partidaDAO.getIdTimeVisitante());

        partida.setTimeLocal(timeLocal.get());
        partida.setTimeVisitante(timeVisitante.get());

        partida.setStatus(Status.valueOf(partidaDAO.getStatus()));
        partida.setResultado(partidaDAO.getResultado());

        return partidaRepository.save(partida);

    }

}
