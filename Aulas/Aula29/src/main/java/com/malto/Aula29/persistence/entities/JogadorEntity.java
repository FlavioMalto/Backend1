package com.malto.Aula29.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TABELA_JOGADORES")
public class JogadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String nome;
    private String posicao;
    private Integer numero;

    //lazy carrega só o id ao invés de carregar o objeto inteiro
    //é o padrão para manytoone e onetomany
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_id")
    private TimeEntity time;

}
