package com.digitalhouse;

import java.util.ArrayList;
import java.util.List;

public class Media {

    private Integer[] listaDeNumeros;
    private Double media;

    public Media(Integer[] listaDeNumeros) {
        this.listaDeNumeros = listaDeNumeros;
    }

    public double calcularMedia(){

        double tamanho = this.listaDeNumeros.length;
        double soma = 0;

        //numero do tipo Integer que representa cada posição da minha lista
        for(Integer numero : this.listaDeNumeros){
            soma += numero;
        }

        return (soma/tamanho);

    }

    public Integer[] getListaDeNumeros() {
        return listaDeNumeros;
    }

    public void setListaDeNumeros(Integer[] listaDeNumeros) {
        this.listaDeNumeros = listaDeNumeros;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
}
