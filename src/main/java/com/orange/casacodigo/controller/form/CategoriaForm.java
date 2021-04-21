package com.orange.casacodigo.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orange.casacodigo.config.CampoUnico;
import com.orange.casacodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @CampoUnico(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria converter() {
        return new Categoria(nome);
    }
}
