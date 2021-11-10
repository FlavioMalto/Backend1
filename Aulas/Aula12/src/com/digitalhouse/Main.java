import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    private static final String createSql =
            "CREATE TABLE Usuario (Id INT PRIMARY KEY, PrimeiroNome VARCHAR2 NOT NULL, Sobrenome VARCHAR2 NOT NULL, Idade INT NOT NULL)";
    private static final String dropSql = "DROP TABLE IF EXISTS Usuario";
    private static final String insertSql =
            "INSERT INTO Usuario (Id, PrimeiroNome, Sobrenome, Idade) VALUES (1, 'Adryana', 'Portugal', 21)";
    private static final String insertSql2 =
            "INSERT INTO Usuario (Id, PrimeiroNome, Sobrenome, Idade) VALUES (2, 'Felipe', 'Rosa', 34)";
    private static final String insertSql3 =
            "INSERT INTO Usuario (Id, PrimeiroNome, Sobrenome, Idade) VALUES (3, 'Vinicius', 'Mendes', 18)";
    private static final String selectSql = "SELECT * FROM Usuario";
    private static final String deleteSql = "DELETE FROM Usuario WHERE Id = 2";


    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(dropSql);
            statement.execute(createSql);
            statement.execute(insertSql);
            statement.execute(insertSql2);
            statement.execute(insertSql3);
            SelectUsuarios(connection);
            statement.execute(deleteSql);
            logger.info("O usuario Felipe foi deletado");
            SelectUsuarios(connection);



        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    private static void SelectUsuarios(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectSql);
        while(resultSet.next()){
            logger.warn("Usuario " + resultSet.getString(2) + " " + resultSet.getString(3));
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/mem:testdb", "sa", "");
    }
}
