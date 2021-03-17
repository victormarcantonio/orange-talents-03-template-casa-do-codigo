package com.orange.casacodigo.model;


import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    private String descricao;
    @NotNull
    private LocalDateTime instante = LocalDateTime.now();

    public Autor() {
    }

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }


}
