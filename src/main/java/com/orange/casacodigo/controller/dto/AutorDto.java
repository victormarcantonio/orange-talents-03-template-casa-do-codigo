package com.orange.casacodigo.controller.dto;

import com.orange.casacodigo.model.Autor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AutorDto {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime instante;


    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.instante = autor.getInstante();
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

    public static List<AutorDto> converter(List<Autor> autores) {
        // TODO Auto-generated method stub
        return autores.stream().map(AutorDto::new).collect(Collectors.toList());
    }
}
