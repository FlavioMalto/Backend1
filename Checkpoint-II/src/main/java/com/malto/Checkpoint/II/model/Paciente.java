package com.malto.Checkpoint.II.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "PACIENTES")
public class Paciente {

    @Id
    @SequenceGenerator(name = "paciente_sequencia", sequenceName = "paciente_sequencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    @ManyToOne
    @JoinColumn(name = "dentista_id")
    @JsonIgnore
    private Dentista dentista;

    public Paciente(String nome, String sobrenome, String email, Dentista dentista) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dentista = dentista;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }
}
