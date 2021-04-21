package com.orange.casacodigo.controller.form;

import com.orange.casacodigo.config.CampoUnico;
import com.orange.casacodigo.model.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class AutorForm {


    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @CampoUnico(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max=400)
    private String descricao;

    public AutorForm(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Length(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    public Autor converter() {
        return new Autor(nome, email, descricao);
    }
}
