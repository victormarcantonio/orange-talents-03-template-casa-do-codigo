package com.orange.casacodigo.controller.dto;

import com.orange.casacodigo.model.Estado;

import java.util.List;
import java.util.stream.Collectors;

public class EstadoDto {
    private String nome;

    public EstadoDto(Estado estado) {
        this.nome = estado.getNome();
    }

    public String getNome() {
        return nome;
    }

    public static List<EstadoDto> listarEstadosPorPais(List<Estado> estados){

        return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
    }

}
