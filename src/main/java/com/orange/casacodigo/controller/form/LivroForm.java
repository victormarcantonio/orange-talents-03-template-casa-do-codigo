package com.orange.casacodigo.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.orange.casacodigo.config.CampoUnico;
import com.orange.casacodigo.config.ExistsById;
import com.orange.casacodigo.model.Autor;
import com.orange.casacodigo.model.Categoria;
import com.orange.casacodigo.model.Livro;
import com.orange.casacodigo.repository.AutorRepository;
import com.orange.casacodigo.repository.CategoriaRepository;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {
    @NotBlank
    @CampoUnico(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @DecimalMin("20.00")
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private int numeroPaginas;
    @NotBlank
    @CampoUnico(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern= "dd/MM/yyyy")
    private LocalDate dataPublicacao;
    @ExistsById(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;
    @NotNull
    @ExistsById(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario, @NotBlank @DecimalMin("20.00") BigDecimal preco, @NotBlank @Size(min = 100) int numeroPaginas, @NotBlank String isbn,  @NotNull Long categoriaId, @NotNull Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }


    /**
     *
     * Setter criado pois o Jackson não consegue desserializar a Data pelo construtor
     */
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository){
      Categoria categoria = categoriaRepository.getOne(categoriaId);
      Autor autor = autorRepository.getOne(autorId);
      return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
    }
}
