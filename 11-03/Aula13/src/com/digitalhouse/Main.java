package com.digitalhouse;

import com.digitalhouse.dao.ServidorH2;
import com.digitalhouse.model.Medicamento;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Medicamento med = new Medicamento(1, "45613296874", "Dorflex", "NeoQuimica", 15, 8.50);
        ServidorH2 servidor = new ServidorH2();

        servidor.insert(med);
        servidor.select(med.getId());
        servidor.selectAll();
        servidor.delete(med.getId());

    }
}
