package com.digitalhouse.dao;

import com.digitalhouse.config.ConfigJDBC;
import com.digitalhouse.model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class ServidorH2 implements  DaoInterface<Medicamento>{

    private ConfigJDBC config = new ConfigJDBC();

    private static final Logger logger = Logger.getLogger(ServidorH2.class);

    @Override
    public Medicamento insert(Medicamento medicamento) {
        String query = String.format("INSERT INTO Medicamento VALUES('%s', '%s', '%s', '%s', '%s', '%s')",
                medicamento.getId(), medicamento.getCodigoNumerico(), medicamento.getNome(), medicamento.getLaboratorio(),
                medicamento.getQuantidade(), medicamento.getPreco());

        try{
            //primeiro tenta criar uma conexão
            Connection connection = config.getConnectionH2();
            //criar um statement
            Statement statement = connection.createStatement();
            //executar a query no banco de dados
            statement.execute(query);
            //fechar o statement
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return medicamento;
    }

    @Override
    public void delete(Integer id) {
        String query = String.format("DELETE FROM Medicamento WHERE id = %s", id);

        try{
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();

            logger.info(String.format("O Medicamento com o id %s foi deletado", id));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void select(Integer id) {
        String query = String.format("SELECT * FROM Medicamento WHERE id = %s", id);

        try{
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                System.out.println("--------------------");
                System.out.println(result.getInt(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getString(4));
                System.out.println(result.getInt(5));
                System.out.println(result.getDouble(6));
                System.out.println("--------------------");
            }
            statement.close();

            logger.info(String.format("O Medicamento com o id %s foi selecionado", id));

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void selectAll() {

        String query = String.format("SELECT * FROM Medicamento");

        try{
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                System.out.println("--------------------");
                System.out.println(result.getInt(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getString(4));
                System.out.println(result.getInt(5));
                System.out.println(result.getDouble(6));
                System.out.println("--------------------");
            }
            statement.close();

            logger.info(String.format("Todos os medicamentos foram selecionados"));

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void selectCodigo(String codigo) {

        String query = String.format("SELECT * FROM Medicamento WHERE codigoNumerico = %s", codigo);

        try {
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("--------------------");
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println(resultSet.getInt(5));
                System.out.println(resultSet.getDouble(6));
                System.out.println("--------------------");
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
