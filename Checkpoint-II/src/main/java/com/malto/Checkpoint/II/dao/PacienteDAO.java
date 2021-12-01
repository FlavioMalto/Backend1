package com.malto.Checkpoint.II.dao;

public class PacienteDAO {

    private String nome;
    private String sobrenome;
    private String email;
    private Integer dentistaId;

    public PacienteDAO(String nome, String sobrenome, String email, Integer dentistaId) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dentistaId = dentistaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(Integer dentistaId) {
        this.dentistaId = dentistaId;
    }
}
