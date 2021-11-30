package com.malto.Aula30.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//indica o hibernate que a classe é uma tabela
@Entity
//altera o nome da tabela
@Table(name = "EQUIPES")
public class Equipe {

    @Id
    //cria diferentes sequencias que serão interpretadas pelo banco de dados
    @SequenceGenerator(name = "equipe_sequencia", sequenceName = "equipe_sequencia", allocationSize = 1)
    //deixa o id incrementando de modo sequencial
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipe_sequencia")
    private Integer id;
    private String nome;
    private String cidade;
    @OneToMany(mappedBy = "equipe")
    private Set<Jogador> jogadores = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setJogadores(Set<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}
