package com.orange.casacodigo.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ValidaEstadoPaisValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidaEstadoPais {
    String message() default
            "Estado não pode ser nulo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
