package com.malto.Aula19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("index/{nome}/{sobrenome}")
    public String index(@PathVariable String nome, @PathVariable String sobrenome, Model model){

        model.addAttribute("nome", nome);
        model.addAttribute("sobrenome", sobrenome);

        return "index";

    }

}
