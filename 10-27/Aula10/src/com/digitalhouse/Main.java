package com.digitalhouse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //indicando aonde o java vai encontrar o arquivo de configuração
        PropertyConfigurator.configure("log4j.properties");

        /*
        logger.info("Nosso Logger está funcionando");
        logger.debug("teste debug");
        logger.error("teste error");
        logger.fatal("teste fatal");
        logger.warn("teste warn");
        logger.trace("teste trace");
        */

        Integer[] lista = {1, 2, 3, 4};

        Media media = new Media(lista);

        media.setMedia(media.calcularMedia());

        if(media.getListaDeNumeros().length >= 10){
            logger.info("Lista de números é maior que 10");
        }else if(media.getListaDeNumeros().length >= 5){
            logger.info("Lista de números é maior que 5");
        }else if(media.getListaDeNumeros().length > 0){
            logger.info("Lista de números é menor que 5");
        }else{
            logger.error("Lista está vazia");
            return;
        }

        logger.info("A média é igual a: " + media.getMedia());
    }
}
