package com.digitalhouse.dao;

import com.digitalhouse.config.ConfigJDBC;
import com.digitalhouse.model.Endereco;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServidorEndereco implements DaoInterface<Endereco> {
    ConfigJDBC configJDBC = new ConfigJDBC();
    private static final Logger logger = Logger.getLogger(ServidorEndereco.class);

    @Override
    public void create() {
        String dropQuery = String.format("DROP TABLE Endereco IF EXISTS");
        String createQuery = String.format(
                "CREATE TABLE IF NOT EXISTS Endereco(id INT PRIMARY KEY AUTO_INCREMENT, rua VARCHAR(100), " +
                        "numero VARCHAR(100), cidade VARCHAR(100), estado VARCHAR(100))");

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(dropQuery);
            statement.execute(createQuery);
            statement.close();
            logger.info("Tabela Endereco foi criada");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Endereco insert(Endereco endereco) {
        String insertQuery = String.format("INSERT INTO Endereco (rua, numero, cidade, estado) VALUES ('%s', '%s', '%s', '%s')",
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado());
        String selectIdQuery = String.format("SELECT id FROM Endereco WHERE (rua = '%s' AND numero = '%s' AND cidade = '%s' AND estado = '%s')",
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado());

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(insertQuery);

            ResultSet resultSet = statement.executeQuery(selectIdQuery);
            while(resultSet.next()) {
                Integer id = resultSet.getInt(1);
                endereco.setId(id);
            }
            statement.close();
            logger.info(String.format("Endereco com id %s foi incluido", endereco.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return endereco;
    }

    @Override
    public void update(Integer id, String coluna, String valorNovo) {
        String updateQuery = String.format("UPDATE Endereco SET %s = '%s' WHERE id = '%s'",
                coluna, valorNovo, id);

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(updateQuery);
            statement.close();
            logger.info(String.format("Endereco com id %s foi atualizado", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String deleteQuery = String.format("DELETE FROM Endereco WHERE id = %s", id);

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(deleteQuery);
            statement.close();
            logger.warn(String.format("Endereco com id %s foi deletado", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select(Integer id) {
        String selectQuery = String.format("SELECT * FROM Endereco WHERE id = %s", id);

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
                        resultSet.getString(5)));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll() {
        String selectQuery = String.format("SELECT * FROM Endereco");

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
                        resultSet.getString(5)));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String selectColuna(Integer id, String coluna) {
        String selectQuery = String.format("SELECT %s FROM Endereco WHERE id = '%s'", coluna, id);
        String valor = "";
        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while(resultSet.next()) {
                valor = resultSet.getString(1);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valor;
    }
}
