package com.malto.Aula29.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "TABELA_TIMES")
public class TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String nome;
    private String cidade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "TABELA_JOGADORES")
    private List<JogadorEntity> jogadores;

}
