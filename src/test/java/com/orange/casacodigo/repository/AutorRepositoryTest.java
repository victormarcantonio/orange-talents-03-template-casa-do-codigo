package com.orange.casacodigo.repository;

import com.orange.casacodigo.model.Autor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AutorRepositoryTest {


    @Mock
    AutorRepository autorRepository;
    @Mock
    Autor autor;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void deveBuscarAutorPorEmail(){
       Autor autor = new Autor("Vitin", "vitin@email.com", "o brabo");
       Mockito.when(autorRepository.findByEmail(autor.getEmail())).thenReturn(Optional.of(autor));
       Assert.notNull(autor);
        Assertions.assertEquals("vitin@email.com", autor.getEmail());
    }

    @Test
    void naoDeveTrazerAutorNaoCadastrado(){

    }
}
