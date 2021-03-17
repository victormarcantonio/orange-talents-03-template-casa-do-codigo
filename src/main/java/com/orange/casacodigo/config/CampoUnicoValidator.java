package com.orange.casacodigo.config;


import com.orange.casacodigo.model.Autor;
import com.orange.casacodigo.model.Categoria;
import com.orange.casacodigo.repository.AutorRepository;
import com.orange.casacodigo.repository.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;


public class CampoUnicoValidator implements ConstraintValidator<CampoUnico, String> {

    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;

    public CampoUnicoValidator(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean isValid(String campo, ConstraintValidatorContext context) {
       Optional<Autor> autor = autorRepository.findByEmail(campo);
       Optional<Categoria> categoria = categoriaRepository.findByNome(campo);
        if (!autor.isPresent() && !categoria.isPresent()) {
            return true;
        }else {
            return false;
        }
    }
}
