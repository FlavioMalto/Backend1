package com.malto.Aula28.controller;

import com.malto.Aula28.persistence.entities.ProdutoEntity;
import com.malto.Aula28.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> getProdutos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> postProduto(@RequestBody ProdutoEntity produtoEntity){
        return ResponseEntity.ok(service.salvar(produtoEntity));
    }

    @PutMapping("/{id}/{quantidade}")
    public ResponseEntity<ProdutoEntity> putProduto(@PathVariable Integer id, @PathVariable Integer quantidade){
        return ResponseEntity.ok(service.subtrair(id, quantidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.ok("Produto deletado com sucesso");
    }

}
