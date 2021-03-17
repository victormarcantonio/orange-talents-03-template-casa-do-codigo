package com.orange.casacodigo.controller.dto;

import com.orange.casacodigo.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroDto {

    private Long id;
    private String titulo;

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<LivroDto> converter(List<Livro> livros) {
        return livros.stream().map(LivroDto::new).collect(Collectors.toList());
    }
}
