package com.orange.casacodigo.controller.form;

import com.orange.casacodigo.config.CampoUnico;
import com.orange.casacodigo.model.Estado;
import com.orange.casacodigo.model.Pais;
import com.orange.casacodigo.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoForm {
    @NotBlank
    @CampoUnico(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    @NotNull
    private Long paisId;

    public EstadoForm(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado converter (PaisRepository paisRepository){
        Pais pais = paisRepository.getOne(paisId);
        return new Estado(nome, pais);
    }
}
