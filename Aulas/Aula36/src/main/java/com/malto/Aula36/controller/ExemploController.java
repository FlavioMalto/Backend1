package com.malto.Aula36.controller;

import com.malto.Aula36.exception.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploController {

    @GetMapping("/{numero}")
    public String validarCalculo(@PathVariable String numero) throws BadRequestException {

        try{
            Integer i = Integer.valueOf(numero) * 2;
            return "É UM NÚMERO";
        }catch (Exception e){
            throw new BadRequestException("NÃO É UM NÚMERO");
        }

    }

}
