package com.orange.casacodigo.config;


import com.orange.casacodigo.model.Categoria;
import com.orange.casacodigo.repository.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NomeCategoriaValidator implements ConstraintValidator<NomeCategoriaUnico, String> {

    private CategoriaRepository categoriaRepository;

    public NomeCategoriaValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext context) {
        Optional<Categoria> categoria = categoriaRepository.findByNome(nome);
        if (!categoria.isPresent()) {
            return true;
        }else {
            return false;
        }
    }
}
