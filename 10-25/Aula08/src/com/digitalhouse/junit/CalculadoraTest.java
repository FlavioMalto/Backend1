package com.digitalhouse.junit;

import org.junit.jupiter.api.Assertions; //assercão é ter certeza de que algo está certo.
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void retornarZero(){
        Calculadora calculadora = new Calculadora();
        //double soma = calculadora.sum();
        Assertions.assertEquals(0,calculadora.sum());
    }

    @Test
    public void retornarSoma(){
        Calculadora calculadora = new Calculadora();
        double soma = calculadora.sum(3, 6, 10);
        Assertions.assertEquals(19, soma);
    }

}
