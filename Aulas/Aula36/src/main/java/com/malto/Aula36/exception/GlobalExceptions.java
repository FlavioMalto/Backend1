package com.malto.Aula36.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//controle de exceções
@ControllerAdvice
public class GlobalExceptions {

    //as chaves são para deixar a exception tratada como um array, podendo adicionar outras
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> processarBadRequest(BadRequestException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
