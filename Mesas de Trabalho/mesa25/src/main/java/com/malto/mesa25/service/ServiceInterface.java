package com.malto.mesa25.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ServiceInterface<T, U> {

    Map<Integer, T> buscar();
    void deletar(Integer id);
    T criar(U dao);
    T editar(U dao);

}
