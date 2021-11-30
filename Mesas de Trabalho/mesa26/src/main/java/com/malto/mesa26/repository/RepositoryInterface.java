package com.malto.mesa26.repository;

import java.util.Map;

public interface RepositoryInterface<T> {

    Map<Integer, T> create(T obj);
    Map<Integer, T> update(T obj, Integer id);
    Map<Integer, T> selectAll();
    Map<Integer, T> select(Integer id);
    void delete(Integer id);

}
