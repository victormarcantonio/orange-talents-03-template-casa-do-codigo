package com.orange.casacodigo.controller;

import com.orange.casacodigo.controller.dto.LivroDto;
import com.orange.casacodigo.controller.form.LivroForm;
import com.orange.casacodigo.model.Livro;
import com.orange.casacodigo.repository.AutorRepository;
import com.orange.casacodigo.repository.CategoriaRepository;
import com.orange.casacodigo.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;
    private LivroRepository livroRepository;

    public LivroController(AutorRepository autorRepository, CategoriaRepository categoriaRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public String cadastrar(@RequestBody @Valid LivroForm form){
       Livro livro = form.converter(autorRepository, categoriaRepository);
       livroRepository.save(livro);
       return livro.toString();
    }

    @GetMapping
    public List<LivroDto> listarLivros(){
       List<Livro> livros = livroRepository.findAll();
       return LivroDto.converter(livros);
    }
}
