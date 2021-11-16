package com.malto.Aula20.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NumeroService {

    //método para jogar 6 número aleatórios (dado)
    public List<Integer> jogar(){

        List<Integer> numerosSorte = new ArrayList<>();
        Random random = new Random();

        for(int i=1;i<=6;i++){
            Integer sorteado = random.nextInt(60-1)+1;
            numerosSorte.add(sorteado);
        }
        return numerosSorte;
    }
}
