package com.orange.casacodigo.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailUnicoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnico {

    String message() default
      "E-mail já cadastrado em nossa base!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
