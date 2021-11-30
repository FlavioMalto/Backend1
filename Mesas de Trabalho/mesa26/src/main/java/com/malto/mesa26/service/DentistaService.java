package com.malto.mesa26.service;

import com.malto.mesa26.dao.DentistaDAO;
import com.malto.mesa26.model.Dentista;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class DentistaService implements ServiceInterface<Dentista, DentistaDAO> {

    private static Map<Integer, Dentista> mapDentista = new HashMap<>();

    @Override
    public Map<Integer, Dentista> buscar() {
        return mapDentista;
    }

    @Override
    public void deletar(Integer id) {
        mapDentista.remove(id);
    }

    @Override
    public Dentista criar(DentistaDAO dao) {

        Integer id = mapDentista.size() + 1;

        mapDentista.put(id, new Dentista(dao.getNome(), dao.getEmail(), dao.getCredencial()));

        return mapDentista.get(id);
    }

    @Override
    public Dentista editar(DentistaDAO dao) {

        Dentista dentista = mapDentista.get(dao.getId());

        dentista.setEmail(dao.getEmail());

        return dentista;
    }
}
