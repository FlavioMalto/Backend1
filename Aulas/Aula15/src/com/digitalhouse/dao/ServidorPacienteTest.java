package com.digitalhouse.dao;

import com.digitalhouse.model.Endereco;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServidorPacienteTest {

    Endereco endereco;
    Endereco endereco2;
    ServidorEndereco servidorEndereco;

    @BeforeEach
    void doBefore() {
        PropertyConfigurator.configure("log4j.properties");
        servidorEndereco = new ServidorEndereco();
        servidorEndereco.create();
        endereco = new Endereco("Primavera", "1", "Sao Paulo", "Sao Paulo");
        endereco2 = new Endereco("Outono", "1", "Maceio", "Alagoas");
    }
    @Test
    void insert() {
        servidorEndereco.insert(endereco);
        String resultado = servidorEndereco.selectColuna(endereco.getId(), "rua");
        assertEquals("Primavera", resultado);
    }




}
