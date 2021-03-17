package com.orange.casacodigo.controller.dto;

import com.orange.casacodigo.model.Autor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AutorDto {


    private String nome;
    private String descricao;


    public AutorDto(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }




    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public static List<AutorDto> converter(List<Autor> autores) {
        // TODO Auto-generated method stub
        return autores.stream().map(AutorDto::new).collect(Collectors.toList());
    }
}
