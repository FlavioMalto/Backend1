package com.malto.Aula36.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception{
    public BadRequestException(String message){
        //super() sobrescreve o campo de mensagem("passa por cima")
        //super() chama o construtor da class mãe
        super(message);
    }
}
