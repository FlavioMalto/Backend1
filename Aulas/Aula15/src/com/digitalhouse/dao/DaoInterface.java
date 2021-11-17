package com.digitalhouse.dao;

public interface DaoInterface<T> {
    public T insert(T t);
    public void create();
    public void update(Integer id, String coluna, String valorNovo);
    public void delete(Integer id);
    public void select(Integer id);
    public void selectAll();
}
