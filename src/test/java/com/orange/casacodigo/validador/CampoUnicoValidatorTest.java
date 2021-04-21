/*
package com.orange.casacodigo.validador;

import com.orange.casacodigo.config.CampoUnico;
import com.orange.casacodigo.config.CampoUnicoValidator;
import com.orange.casacodigo.controller.form.AutorForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidatorContext;

public class CampoUnicoValidatorTest {


     @Mock
    ConstraintValidatorContext context;

     @PersistenceContext
     EntityManager entityManager;

    @DisplayName("Deve retornar true caso a lista esteja vazia")
    @Test
    void teste01(){

        CampoUnicoValidator validador = new CampoUnicoValidator(entityManager);
        AutorForm form = new AutorForm("Vitin", "victor@email.com", "livros policiais");
        CampoUnico campoUnico = new CampoUnico();
        Assert.isTrue(validador.isValid("Brasil", context));
    }
}
*/
