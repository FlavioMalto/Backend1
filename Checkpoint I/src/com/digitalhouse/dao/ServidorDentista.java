package com.digitalhouse.dao;

import com.digitalhouse.config.ConfigJDBC;
import com.digitalhouse.model.Dentista;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ServidorDentista implements DaoInterface<Dentista>{

    private ConfigJDBC configJDBC = new ConfigJDBC();

    private static final Logger logger = Logger.getLogger(ServidorDentista.class);

    @Override
    public void create() {

        String dropQuery = String.format("DROP TABLE Dentista IF EXISTS");

        String createQuery = String.format("CREATE TABLE IF NOT EXISTS Dentista(" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "numeroMatricula INT NOT NULL," +
                "nome VARCHAR(255) NOT NULL, " +
                "sobrenome VARCHAR(255) NOT NULL)");

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(dropQuery);
            statement.execute(createQuery);
            statement.close();

            logger.info("Tabela Dentista foi criada");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Dentista insert(Dentista dentista) {
        String insertQuery = String.format("INSERT INTO Dentista (numeroMatricula, nome, sobrenome) VALUES('%s', '%s', '%s')",
                dentista.getNumeroMatricula(),
                dentista.getNome(),
                dentista.getSobrenome());
        String selectIdQuery = String.format("SELECT id FROM Dentista WHERE numeroMatricula = %s",
                dentista.getNumeroMatricula());

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(insertQuery);

            ResultSet result = statement.executeQuery(selectIdQuery);
            while(result.next()) {
                Integer id = result.getInt(1);
                dentista.setId(id);
            }
            statement.close();
            logger.info(String.format("Dentista %s %s foi incluido", dentista.getNome(), dentista.getSobrenome()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dentista;

    }



    @Override
    public void update(Integer id, String coluna, String valorNovo) {

        String updateQuery = String.format("UPDATE Dentista SET %s = '%s' WHERE id = '%s'",
                coluna, valorNovo, id);

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(updateQuery);
            statement.close();
            logger.info(String.format("Dentista com id %s foi atualizado", id));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {

        String query = String.format("DELETE FROM Dentista WHERE id = %s", id);

        try{
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();

            logger.info(String.format("O Dentista com o id %s deletado", id));

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void select(Integer id) {

        String query = String.format("SELECT * FROM Dentista WHERE id = %s", id);

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                System.out.println("--------------------");
                System.out.println(result.getInt(1));
                System.out.println(result.getInt(2));
                System.out.println(result.getString(3));
                System.out.println(result.getString(4));
                System.out.println("--------------------");
            }
            statement.close();

            logger.info(String.format("O Dentista com o id %s foi selecionado", id));


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList selectAll() {

        String query = String.format("SELECT * FROM Dentista");
        ArrayList<String> selectAllArray = new ArrayList<>();

        try{
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                String dentistaFrase = String.format("\n-------------------- \n%s \n%s \n%s \n%s \n--------------------",
                result.getInt(1),
                result.getInt(2),
                result.getString(3),
                result.getString(4));
                selectAllArray.add(dentistaFrase);
                System.out.println(dentistaFrase);
            }

            statement.close();

            logger.info(String.format("Todos os dentistas foram selecionados"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return selectAllArray;
    }

    @Override
    public void selectMatricula(Integer matricula) {

        String query = String.format("SELECT * FROM Dentista WHERE numeroMatricula = %s", matricula);

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("--------------------");
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getInt(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println("--------------------");
            }
            statement.close();

            logger.info(String.format("O Dentista com o número de matrícula %s foi selecionado", matricula));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
