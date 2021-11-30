package com.malto.mesa26.repository;

import com.malto.mesa26.model.Dentista;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DentistaRepository implements RepositoryInterface<Dentista>{

    public static Map<Integer, Dentista> dentistaMap = new HashMap<>();

    @Override
    public Map<Integer, Dentista> create(Dentista obj) {
        Integer id = dentistaMap.size() + 1;

        dentistaMap.put(id, obj);

        Map<Integer, Dentista> create = new HashMap<>();
        create.put(id, dentistaMap.get(id));

        return create;
    }

    @Override
    public Map<Integer, Dentista> update(Dentista obj, Integer id) {
        Dentista updateFilme = dentistaMap.get(id);

        updateFilme.setEmail(obj.getEmail());
        updateFilme.setCredencial(obj.getCredencial());

        Map<Integer, Dentista> update = new HashMap<>();
        update.put(id, dentistaMap.get(id));

        return update;
    }

    @Override
    public Map<Integer, Dentista> selectAll() {
        return dentistaMap;
    }

    @Override
    public Map<Integer, Dentista> select(Integer id) {

        Map<Integer, Dentista> select = new HashMap<>();
        select.put(id, dentistaMap.get(id));

        return select;
    }

    @Override
    public void delete(Integer id) {

        dentistaMap.remove(id);
    }
}
