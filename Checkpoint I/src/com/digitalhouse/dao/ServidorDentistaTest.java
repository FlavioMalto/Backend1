package com.digitalhouse.dao;

import com.digitalhouse.dao.ServidorDentista;
import com.digitalhouse.model.Dentista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServidorDentistaTest {

    Dentista dentista1;
    Dentista dentista2;
    Dentista dentista3;
    ServidorDentista servidorDentista;

    @BeforeEach
    void doBefore() {
        PropertyConfigurator.configure("log4j.properties");

        servidorDentista = new ServidorDentista();
        servidorDentista.create();

        dentista1 = new Dentista(11, "Lucas", "Cromo");
        dentista2 = new Dentista(12,"Fernanda", "Plotegher");
        dentista3 = new Dentista(13,"Telma", "Plotegher");

        servidorDentista.insert(dentista1);
        servidorDentista.insert(dentista2);
        servidorDentista.insert(dentista3);

    }

    @Test
    void selectAllTest() {

        ArrayList<String> ArraySelectAll = servidorDentista.selectAll();
        ArrayList<String> ArrayEsperado = new ArrayList<>();

        String dentistaFrase1 = String.format("\n-------------------- \n%s \n%s \n%s \n%s \n--------------------",
                dentista1.getId(),
                dentista1.getNumeroMatricula(),
                dentista1.getNome(),
                dentista1.getSobrenome());
        String dentistaFrase2 = String.format("\n-------------------- \n%s \n%s \n%s \n%s \n--------------------",
                dentista2.getId(),
                dentista2.getNumeroMatricula(),
                dentista2.getNome(),
                dentista2.getSobrenome());
        String dentistaFrase3 = String.format("\n-------------------- \n%s \n%s \n%s \n%s \n--------------------",
                dentista3.getId(),
                dentista3.getNumeroMatricula(),
                dentista3.getNome(),
                dentista3.getSobrenome());

        ArrayEsperado.add(dentistaFrase1);
        ArrayEsperado.add(dentistaFrase2);
        ArrayEsperado.add(dentistaFrase3);

        assertEquals(ArrayEsperado, ArraySelectAll);

    }




}
