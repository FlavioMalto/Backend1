package Aula04;

import Aula04.model.Mail;
import Aula04.service.CheckEmail;
import Aula04.service.impl.Comercial;
import Aula04.service.impl.Gerente;
import Aula04.service.impl.Tecnico;

public class Main {

    public static void main(String[] args) {

        Mail mail = new Mail("flavio@hotmail.com", "terra@colmeia.com", "Spring Boot");

        String[] emailValidado = mail.getDestino().split("@");

        CheckEmail checkEmail;

        if(emailValidado[1].equals("colmeia.com")){
          checkEmail = new Gerente()
                  .setProximoDestinatario(new Comercial()
                          .setProximoDestinatario(new Tecnico()));
        }else{
            checkEmail = new Tecnico();
        }

        checkEmail.processarEmail(mail, emailValidado[0]);

    }
}
