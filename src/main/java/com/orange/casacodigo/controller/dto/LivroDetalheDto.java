package com.orange.casacodigo.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.orange.casacodigo.config.CampoUnico;
import com.orange.casacodigo.model.Autor;
import com.orange.casacodigo.model.Livro;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalheDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numeroPaginas;
    private String isbn;
    private AutorDto autor;

    public LivroDetalheDto(Livro livro) {
        this.autor = new AutorDto(livro.getAutor());
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public AutorDto getAutor() {
        return autor;
    }
}
