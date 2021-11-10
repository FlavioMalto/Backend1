package com.malto.Aula18.domain;

public class Professor {

    private String nome;
    private Integer idade;
    private String especialidade;

    public Professor(String nome, Integer idade, String especialidade) {
        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
