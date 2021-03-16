package com.orange.casacodigo.config;


import com.orange.casacodigo.model.Autor;
import com.orange.casacodigo.repository.AutorRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;


public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

    private AutorRepository autorRepository;

    public EmailUnicoValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public void initialize(EmailUnico constraint) {}

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
       Optional<Autor> autor = autorRepository.findByEmail(email);
        if (!autor.isPresent()) {
            return true;
        }else {
            return false;
        }
    }
}
