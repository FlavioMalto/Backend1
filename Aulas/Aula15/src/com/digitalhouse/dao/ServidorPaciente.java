package com.digitalhouse.dao;

import com.digitalhouse.config.ConfigJDBC;
import com.digitalhouse.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServidorPaciente implements DaoInterface<Paciente> {

    private ConfigJDBC configJDBC = new ConfigJDBC();

    private static final Logger logger = Logger.getLogger(ServidorPaciente.class);


    @Override
    public Paciente insert(Paciente paciente) {
        String insertQuery = String.format("INSERT INTO Paciente (nome, sobrenome, rg, datacadastro, enderecoId) VALUES('%s', '%s', '%s', '%s')",
                paciente.getNome(),
                paciente.getSobrenome(),
                paciente.getRg(),
//                paciente.getDataCadastro());
                paciente.getEndereco().getId());
        String selectIdQuery = String.format("SELECT id FROM Paciente WHERE rg = %s",
                paciente.getRg());

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(insertQuery);

            ResultSet resultSet = statement.executeQuery(selectIdQuery);
            while(resultSet.next()) {
                Integer id = resultSet.getInt(1);
                paciente.setId(id);
            }
            statement.close();
            logger.info(String.format("Paciente %s %s foi incluido", paciente.getNome(), paciente.getSobrenome()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
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
    public void update(Integer id, String coluna, String valorNovo) {
        String updateQuery = String.format("UPDATE Paciente SET %s = '%s' WHERE id = '%s'",
                coluna, valorNovo, id);

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(updateQuery);
            statement.close();
            logger.info(String.format("Paciente com id %s foi atualizado", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String deleteQuery = String.format("DELETE FROM Paciente WHERE id = %s", id);

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(deleteQuery);
            statement.close();
            logger.warn(String.format("Paciente com id %s foi deletado", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select(Integer id) {
        String selectQuery = String.format("SELECT * FROM Paciente WHERE id = %s", id);

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                logger.info(String.format("\n***** \n%s \n%s \n%s \n%s \n%s \n*****",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll() {
        String selectQuery = String.format("SELECT * FROM Paciente");

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                logger.info(String.format("\n***** \n%s \n%s \n%s \n%s \n%s \n*****",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

