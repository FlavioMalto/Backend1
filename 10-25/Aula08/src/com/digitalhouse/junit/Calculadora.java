package com.digitalhouse.junit;

public class Calculadora {

    //criando uma espécie de array com variáveis do tipo double e adicionando em numbers
    public double sum(double... numbers){
        double sum = 0;
        if(numbers.length > 0){
            //percorre os indices do array somando-os e atribuindo a variável sum.
            for(double number : numbers){
                sum += number;
            }
        }
        return sum;
    }

}
