package Aula04.service.impl;

import Aula04.model.Mail;
import Aula04.service.CheckEmail;

public class Gerente extends CheckEmail {
    @Override
    public void processarEmail(Mail mail, String nomeDestinatario) {

        if(nomeDestinatario.equals("gerente")) {
            System.out.println("Esse E-mail é do Gerente e chegou ao seu Destinatário");
        }else {
            this.proximoDestinatario.processarEmail(mail, nomeDestinatario);
        }
    }
}
