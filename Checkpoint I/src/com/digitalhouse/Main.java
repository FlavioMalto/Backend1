package com.digitalhouse;

import com.digitalhouse.dao.ServidorDentista;
import com.digitalhouse.model.Dentista;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");

        Dentista dentista1 = new Dentista(11, "Lucas", "Cromo");
        Dentista dentista2 = new Dentista(12,"Fernanda", "Plotegher");
        Dentista dentista3 = new Dentista(13,"Telma", "Plotegher");

        ServidorDentista servidorDentista = new ServidorDentista();
        servidorDentista.create();
        servidorDentista.insert(dentista1);
        servidorDentista.insert(dentista2);
        servidorDentista.insert(dentista3);

        servidorDentista.select(dentista1.getId());

        servidorDentista.selectAll();

        servidorDentista.delete(dentista3.getId());

        servidorDentista.selectMatricula(dentista2.getNumeroMatricula());




    }
}
