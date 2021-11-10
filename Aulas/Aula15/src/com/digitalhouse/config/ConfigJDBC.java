package com.digitalhouse.config;

import java.sql.Connection;
import java.sql.DriverManager;

//configuração da conexão com o banco de dados
public class ConfigJDBC {

    public Connection getConnectionH2() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }


}
