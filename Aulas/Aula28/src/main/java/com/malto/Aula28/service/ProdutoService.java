package com.malto.Aula28.service;

import com.malto.Aula28.persistence.entities.ProdutoEntity;
import com.malto.Aula28.persistence.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoEntity> buscarTodos(){
        return repository.findAll();
    }

    public ProdutoEntity salvar(ProdutoEntity produtoEntity){
        return repository.save(produtoEntity);
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }

    public ProdutoEntity subtrair(Integer id, Integer quantidade){
        ProdutoEntity produtoEntity = repository.findById(id).get();
        produtoEntity.setQuantidade(produtoEntity.getQuantidade()-quantidade);

        return produtoEntity;
    }


}
