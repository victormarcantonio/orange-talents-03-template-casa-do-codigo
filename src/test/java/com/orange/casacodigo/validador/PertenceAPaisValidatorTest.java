package com.orange.casacodigo.validador;

import com.orange.casacodigo.config.PertenceAPaisValidator;
import com.orange.casacodigo.controller.form.ClienteForm;
import com.orange.casacodigo.model.Cliente;
import com.orange.casacodigo.model.Estado;
import com.orange.casacodigo.model.Pais;
import com.orange.casacodigo.repository.EstadoRepository;
import com.orange.casacodigo.repository.PaisRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

public class PertenceAPaisValidatorTest {


    PaisRepository paisRepository = Mockito.mock(PaisRepository.class);
    EstadoRepository estadoRepository = Mockito.mock(EstadoRepository.class);
    ClienteForm clienteForm = new ClienteForm("victor@email.com","vitin","marco","464.311.868-77","rua fidalga","ap 14","sp",1L,"123","123");
    Pais pais = new Pais("Brasil");

    @DisplayName("Deve retornar true caso o país não possua estado")
    @Test
    void teste01(){

        PertenceAPaisValidator validador = new PertenceAPaisValidator(paisRepository, estadoRepository);
        Errors errors = new BeanPropertyBindingResult(clienteForm, "target");
        validador.validate(clienteForm, errors);
        Assertions.assertEquals(0, errors.getErrorCount());
    }

    @DisplayName("Deve barrar compra caso estado não pertença ao país")
    @Test
    void teste02(){
        Pais paisDiferente = new Pais("Espanha");
        Estado estado = new Estado("Sao Paulo", paisDiferente);
        Mockito.when(paisRepository.getOne(1L)).thenReturn(pais);
        Mockito.when(estadoRepository.getOne(2L)).thenReturn(estado);
        PertenceAPaisValidator validador = new PertenceAPaisValidator(paisRepository, estadoRepository);
        clienteForm.setEstadoId(2L);
        Errors errors = new BeanPropertyBindingResult(clienteForm, "target");
        validador.validate(clienteForm, errors);
        Assertions.assertEquals(1, errors.getErrorCount());
    }

    @DisplayName("Deve permitir compra caso o estado pertença ao país")
    @Test
    void teste03(){
        Estado estado = new Estado("Sao Paulo", pais);
        Mockito.when(paisRepository.getOne(1L)).thenReturn(pais);
        Mockito.when(estadoRepository.getOne(1L)).thenReturn(estado);
        PertenceAPaisValidator validador = new PertenceAPaisValidator(paisRepository, estadoRepository);
        clienteForm.setEstadoId(1L);
        Errors errors = new BeanPropertyBindingResult(clienteForm, "target");
        validador.validate(clienteForm, errors);
        Assertions.assertEquals(0, errors.getErrorCount());
    }

}
