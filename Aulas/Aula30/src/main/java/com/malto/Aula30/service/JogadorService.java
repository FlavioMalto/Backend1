package com.malto.Aula30.service;

import com.malto.Aula30.dao.JogadorDAO;
import com.malto.Aula30.model.Equipe;
import com.malto.Aula30.model.Jogador;
import com.malto.Aula30.model.Treinador;
import com.malto.Aula30.repository.EquipeRepository;
import com.malto.Aula30.repository.JogadorRepository;
import com.malto.Aula30.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private TreinadorRepository treinadorRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    public Jogador insert(JogadorDAO jogadorDAO){
        Treinador treinador = treinadorRepository.getById(jogadorDAO.getTreinadorId());
        Equipe equipe = equipeRepository.getById(jogadorDAO.getEquipeId());

        Jogador jogador = new Jogador(jogadorDAO.getNome(), jogadorDAO.getPosicao(),
                jogadorDAO.getNumero(), equipe, treinador);

        return jogadorRepository.save(jogador);
    }

    public List<String> buscarPorTreinador(Integer idTreinador){
        Treinador treinador = treinadorRepository.getById(idTreinador);

        return jogadorRepository.findAllJogadoresPorTreinador(treinador);
    }



}
