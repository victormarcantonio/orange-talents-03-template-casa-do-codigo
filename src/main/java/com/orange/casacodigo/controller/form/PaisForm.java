package com.orange.casacodigo.controller.form;

import com.orange.casacodigo.config.CampoUnico;
import com.orange.casacodigo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    @CampoUnico(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }
}
