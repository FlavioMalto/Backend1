package Aula04.service.impl;

import Aula04.model.Mail;
import Aula04.service.CheckEmail;

public class Tecnico extends CheckEmail {
    @Override
    public void processarEmail(Mail mail, String nomeDestinatario) {
        String[] arrayMail = mail.getDestino().split("@");

        if(nomeDestinatario.equals("tecnico")) {
            System.out.println("Esse E-mail é do Técnico e chegou ao seu Destinatário");
        }else {
            System.out.println("Esse E-mail é um SPAM");
        }
    }
}
