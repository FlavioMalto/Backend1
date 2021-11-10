package com.digitalhouse.dao;

import java.util.ArrayList;

public interface DaoInterface<T> {
    public void create();
    public T insert(T t);
    public void update(Integer id, String coluna, String valorNovo);
    public void delete(Integer id);
    public void select(Integer id);
    public ArrayList selectAll();
    public void selectMatricula(Integer matricula);
}
