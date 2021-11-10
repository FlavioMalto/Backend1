package com.digitalhouse.dao;

import com.digitalhouse.config.ConfigJDBC;
import com.digitalhouse.model.Paciente;

import java.sql.Connection;
import java.sql.Statement;

public class ServidorPaciente implements DaoInterface<Paciente> {

    private ConfigJDBC configJDBC = new ConfigJDBC();

    @Override
    public Paciente insert(Paciente paciente) {
        return null;
    }

    @Override
    public void create() {
        String query = String.format("CREATE TABLE IF NOT EXISTS Paciente(" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nome VARCHAR(100), " +
                "sobrenome VARCHAR(100), " +
                "rg VARCHAR(100), " +
                "dataCadastro DATETIME, " +
                "enderecoId INT NOT NULL)");

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void update(Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void select(Integer id) {

    }

    @Override
    public void selectAll() {

    }
}
