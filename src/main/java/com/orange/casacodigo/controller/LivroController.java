package com.orange.casacodigo.controller;

import com.orange.casacodigo.controller.dto.LivroDetalheDto;
import com.orange.casacodigo.controller.dto.LivroDto;
import com.orange.casacodigo.controller.form.LivroForm;
import com.orange.casacodigo.model.Livro;
import com.orange.casacodigo.repository.AutorRepository;
import com.orange.casacodigo.repository.CategoriaRepository;
import com.orange.casacodigo.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    @Transactional
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

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalheDto> detalheLivro(@PathVariable Long id){
        Optional<Livro>livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok(new LivroDetalheDto(livro.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
