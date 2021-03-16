package com.orange.casacodigo.controller.form;

import com.orange.casacodigo.config.NomeCategoriaUnico;
import com.orange.casacodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @NomeCategoriaUnico
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        return new Categoria(nome);
    }
}