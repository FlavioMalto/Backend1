package com.malto.Checkpoint.II.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DENTISTAS")
public class Dentista {

    @Id
    @SequenceGenerator(name = "dentista_sequencia", sequenceName = "dentista_sequencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private String email;
    private String credencial;
    @OneToMany(mappedBy = "dentista")
    private Set<Paciente> pacientes = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCredencial() {
        return credencial;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
