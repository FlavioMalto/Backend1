package com.malto.Aula28.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TABELA_PRODUTOS")
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private Integer quantidade;
    private String descricao;

}
