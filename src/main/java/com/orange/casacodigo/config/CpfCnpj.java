package com.orange.casacodigo.config;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@ConstraintComposition(CompositionType.OR)
@CPF
@CNPJ
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CpfCnpj {

    String message() default
            "CNPJ/CPF inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
