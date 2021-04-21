package com.orange.casacodigo.controller;

import com.orange.casacodigo.controller.form.CategoriaForm;
import com.orange.casacodigo.model.Categoria;
import com.orange.casacodigo.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid CategoriaForm form) {
        Categoria categoria = form.converter();
        categoriaRepository.save(categoria);
        return categoria.toString();
    }
}
