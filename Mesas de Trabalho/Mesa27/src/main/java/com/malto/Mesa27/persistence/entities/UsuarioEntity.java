package com.malto.Mesa27.persistence.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;

@Entity
@Table(name = "TABELA_USUARIOS")
@Getter
@Setter
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @
    private String usuario;
    private String password;

}
