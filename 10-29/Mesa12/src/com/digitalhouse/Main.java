package com.digitalhouse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class Main {
//    Enunciado
//    Utilizaremos um statement para criar uma tabela de funcionários com cinco colunas.
//    A única coluna obrigatória será a coluna ID, que também é Primary Key, e as demais colunas são de livre escolha.
//    Em seguida:
//    Devemos inserir três linhas com dados diferentes, e uma delas deve conter o ID repetido;
//    Verificar se está ocorrendo o erro: “Unique index or primary key violation”,
//    ocasionado ao tentar inserir dois registros com o mesmo ID. Então devemos tratá-lo como exceção,
//    registar o erro em log e continuar com a execução das demais instruções;
//    Em seguida, você deve atualizar um dos funcionários com um novo valor em uma de suas colunas e
//    registrar com um objeto de depuração (debug) as informações do funcionário;
//    Posteriormente, temos que excluir um funcionários de acordo com o ID e registrar as informações
//    do funcionário excluído como um objeto de informação (info);
//    Por último, excluir outro funcionário utilizando como critério outra coluna que não seja o ID,
//    como por exemplo o e-mail, e registrar as informações do funcionário excluído como um objeto de informação (info).

    private static final Logger logger = Logger.getLogger(Main.class);

    private static final String dropSql =
            "DROP TABLE IF EXISTS Funcionario";
    private static final String createSql =
            "CREATE TABLE Funcionario (Id INT PRIMARY KEY, Nome VARCHAR2, Sobrenome VARCHAR2, Idade INT, Cargo VARCHAR2)";
    private static final String insertSql1 =
            "INSERT INTO Funcionario (Id, Nome, Sobrenome, Idade, Cargo) VALUES (1, 'Renata', 'Leal', 22, 'CEO')";
    private static final String insertSql2 =
            "INSERT INTO Funcionario (Id, Nome, Sobrenome, Idade, Cargo) VALUES (2, 'Adryana', 'Portugal', 21, 'PO')";
    private static final String insertSql3 =
            "INSERT INTO Funcionario (Id, Nome, Sobrenome, Idade, Cargo) VALUES (3, 'Clarissa', 'Farencena', 23, 'PM')";
    private static final String insertSql4 =
            "INSERT INTO Funcionario (Id, Nome, Sobrenome, Idade, Cargo) VALUES (4, 'Joao', 'Silva', 23, 'Estagiario')";
    private static final String insertSql5 =
            "INSERT INTO Funcionario (Id, Nome, Sobrenome, Idade, Cargo) VALUES (4, 'Joao', 'Silva', 23, 'Trocou')";
    private static final String deleteSql =
            "DELETE FROM Funcionario WHERE Id = 4";
    private static final String selectSql =
            "SELECT * FROM Funcionario";

    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(dropSql);
            statement.execute(createSql);
            statement.execute(insertSql1);
            statement.execute(insertSql2);
            statement.execute(insertSql3);
            statement.execute(insertSql4);
            selectUsuarios(connection);
            statement.execute(deleteSql);
            selectUsuarios(connection);

            try {
                statement.execute(insertSql5);
            } catch (Exception e) {
                logger.warn("Esse id ja existe");
            }

        } catch(Exception e) {
            logger.warn(e);
        }

    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/mem:testdb", "sa", "");
    }

    private static void selectUsuarios(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectSql);
        logger.info("*****");
        while (resultSet.next()) {
            logger.info(String.format("%s %s %s %s %s",
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)));
        }
    }
}
