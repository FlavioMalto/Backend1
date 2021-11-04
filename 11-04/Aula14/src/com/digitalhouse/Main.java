package com.digitalhouse;

import com.digitalhouse.model.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro dog1 = new Cachorro("Mel", 10);
        Cachorro dog2 = new Cachorro("Snow", 5);
        Cachorro dog3 = new Cachorro("Theo", 2);

        cachorros.add(dog1);
        cachorros.add(dog2);
        cachorros.add(dog3);

        //Criar arquivo
        FileOutputStream fileOut;

        try{
            fileOut = new FileOutputStream("ListaCachorros.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(cachorros);

        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        }catch (Exception e){
            e.printStackTrace();
        }

        //Para ler um arquivo
        List<Cachorro> cachorros2 = null;
        FileInputStream fileInput;

        try {
            fileInput = new FileInputStream("ListaCachorros.txt");
            ObjectInputStream objIn = new ObjectInputStream(fileInput);

            cachorros2 = (ArrayList) objIn.readObject();

        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        }catch (Exception e){
            e.printStackTrace();
        }

        for(Cachorro dog : cachorros2){
            System.out.println("Nome: " + dog.getNome() +" - Idade: " + dog.getIdade());
        }

    }
}
