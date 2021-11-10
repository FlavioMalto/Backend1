package com.digitalhouse;

import com.digitalhouse.model.Contato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        Você deve manter uma lista de contatos em um arquivo. Os contatos possuem
        um nome, e-mail e telefone. Para fazer isso, sugerimos que você utilize o
        método main para salvar a coleção de contatos em um arquivo e, em seguida,
        recupere o conteúdo do arquivo para outra coleção e exiba a lista de contatos
        no console.
        */

        List<Contato> contatos = new ArrayList<>();

        Contato contato1 = new Contato("Flavio", "flavio@email.com", "11111111");
        Contato contato2 = new Contato("Helena", "helena@email.com", "22222222");
        Contato contato3 = new Contato("Renata", "renata@email.com", "33333333");

        contatos.add(contato1);
        contatos.add(contato2);
        contatos.add(contato3);

        //Criar arquivo

        try{
            FileOutputStream fileOut = new FileOutputStream("ListaContatos.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(contatos);

        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        }catch (Exception e){
            e.printStackTrace();
        }

        //Para ler um arquivo
        List<Contato> contatos2 = null;

        try {
            FileInputStream fileInput = new FileInputStream("ListaContatos.txt");
            ObjectInputStream objIn = new ObjectInputStream(fileInput);

            contatos2 = (ArrayList) objIn.readObject();

        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        }catch (Exception e){
            e.printStackTrace();
        }

        for(Contato contato : contatos2){
            System.out.println("Nome: " + contato.getNome() +" - E-mail: " + contato.getEmail() + " - Telefone: " + contato.getTelefone());
        }

    }
}
