package com.malto.Aula22.service;


import com.malto.Aula22.dao.DentistaDAO;
import com.malto.Aula22.domain.Dentista;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DentistaService {

    private static Map<Integer, Dentista> flyweight = new HashMap<>();

    public Dentista registrarDentista(DentistaDAO dentistaDAO) {

        Integer id = flyweight.size() + 1; //para não começar com 0

        Dentista dentista = new Dentista(dentistaDAO.getNome(), dentistaDAO.getSobrenome(), dentistaDAO.getMatricula());

        flyweight.put(id, dentista);

        return flyweight.get(id);

    }

    public Dentista buscarDentista(Integer id) {

        Dentista dentista = flyweight.get(id);

        return dentista;

    }

    public Map<Integer, Dentista> listarDentistas() {
        return flyweight;
    }

    public Dentista atualizarDentista(DentistaDAO dentistaDAO) {

        Dentista dentista = flyweight.get(dentistaDAO.getId());

        dentista.setNome(dentistaDAO.getNome());
        dentista.setSobrenome(dentistaDAO.getSobrenome());

        return dentista;

    }

    public String deletarDentista(Integer id) {

        flyweight.remove(id);

        return String.format("O dentista de id %s foi deletado", id);

    }


}
