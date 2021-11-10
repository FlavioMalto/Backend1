package com.digitalhouse;

import java.sql.*;

public class Main {

    private static final String sqlCreate = "CREATE TABLE Animal (id INT PRIMARY KEY, Nome VARCHAR(100) NOT NULL, Tipo VARCHAR(120) NOT NULL)";
    private static final String sqlDrop = "DROP TABLE IF EXISTS Animal";

    private static final String sqlInsert = "INSERT INTO Animal (id, Nome, Tipo) VALUES (1, 'Eevee', 'Cachorro')";
    private static final String sqlInsert2 = "INSERT INTO Animal (id, Nome, Tipo) VALUES (2, 'Bichano', 'Gato')";
    private static final String sqlInsert3 = "INSERT INTO Animal (id, Nome, Tipo) VALUES (3, 'Bidu', 'Cachorro')";
    private static final String sqlInsert4 = "INSERT INTO Animal (id, Nome, Tipo) VALUES (4, 'Mingau', 'Gato')";
    private static final String sqlInsert5 = "INSERT INTO Animal (id, Nome, Tipo) VALUES (5, 'Tom', 'Gato')";

    private static final String sqlDelete = "DELETE FROM Animal WHERE id=1";

    private static final String sqlSelect = "SELECT * FROM Animal";

    public static void main(String[] args){
        Connection connection = null;

        try{
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(sqlDrop);
            statement.execute(sqlCreate);

            statement.execute(sqlInsert);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
            statement.execute(sqlInsert4);
            statement.execute(sqlInsert5);

            //statement.execute(sqlSelect);
            mostrarAnimais(connection);

            statement.execute(sqlDelete);

            mostrarAnimais(connection);
            //statement.execute(sqlSelect);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void  mostrarAnimais(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        //ResultSet é um objeto dentro do java (tipo de variável) em formato de tabela. Irá armazenar o resultado do select.
        ResultSet resultado = statement.executeQuery(sqlSelect);

        //next é um recurso do ResultSet que mostra a próxima linha na sua tabela. Poderíamos usar um for para percorrer as colunas.
        while (resultado.next()){
            System.out.println("");
            System.out.println(resultado.getInt(1) + " " + resultado.getString(2) + " " + resultado.getString(3));
        }
        System.out.println("--------------------------");
    }

    public static Connection getConnection() throws Exception{

        Class.forName("org.h2.Driver");

        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

    }
}
