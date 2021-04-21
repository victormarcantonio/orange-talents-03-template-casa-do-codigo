package com.orange.casacodigo.form;

import com.orange.casacodigo.controller.form.ClienteForm;
import com.orange.casacodigo.model.Cliente;
import com.orange.casacodigo.model.Estado;
import com.orange.casacodigo.model.Pais;
import com.orange.casacodigo.repository.EstadoRepository;
import com.orange.casacodigo.repository.PaisRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClienteFormTest {

    @Mock
    PaisRepository paisRepository;
    @Mock
    EstadoRepository estadoRepository;

    @DisplayName("Deve adicionar o estado ao cliente caso o estado seja enviado no form")
    @Test
    void teste01(){
        Pais pais = new Pais("Brasil");
        Estado estado = new Estado("SP", pais);
        Mockito.when(paisRepository.getOne(1L)).thenReturn(pais);
        Mockito.when(estadoRepository.getOne(1L)).thenReturn(estado);
        ClienteForm form = new ClienteForm("vitin@email.com","victor","marco","1234","rua fudalga","ap 14", "SP",1L,"hxuwheuhd","12345");
        form.setEstadoId(1L);
        Cliente clienteEsperado = form.converter(paisRepository,estadoRepository);
        Assertions.assertEquals(clienteEsperado.getEstado(),estado);
    }

    @DisplayName("Cliente deve estar com estado nulo, caso estado não seja enviado")
    @Test
    void teste02(){
        Pais pais = new Pais("Brasil");
        Mockito.when(paisRepository.getOne(1L)).thenReturn(pais);
        ClienteForm form = new ClienteForm("vitin@email.com","victor","marco","1234","rua fudalga","ap 14", "SP",1L,"hxuwheuhd","12345");
        form.setEstadoId(1L);
        Cliente clienteEsperado = form.converter(paisRepository,estadoRepository);
        Assertions.assertNull(clienteEsperado.getEstado());
    }
}
