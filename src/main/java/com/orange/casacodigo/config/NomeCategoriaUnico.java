package com.orange.casacodigo.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NomeCategoriaValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NomeCategoriaUnico {
    String message() default
            "Nome de categoria já cadastrado!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
