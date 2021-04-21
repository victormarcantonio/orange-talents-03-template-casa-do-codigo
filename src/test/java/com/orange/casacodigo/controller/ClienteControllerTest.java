package com.orange.casacodigo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.casacodigo.config.PertenceAPaisValidator;
import com.orange.casacodigo.controller.form.ClienteForm;
import com.orange.casacodigo.model.Pais;
import com.orange.casacodigo.repository.ClienteRepository;
import com.orange.casacodigo.repository.EstadoRepository;
import com.orange.casacodigo.repository.PaisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonMapper;

    @Autowired
    PaisRepository paisRepository;


    @DisplayName("Deve cadastrar cliente")
    @Test
    void teste01() throws Exception {
        Pais pais = new Pais("Espanha");
        paisRepository.save(pais);
        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
        .content(json(new ClienteForm("vitin@email.com","victor","marco","526.911.750-90","rua fudalga","ap 14", "SP",1L,"hdewde","12345")))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }


    public String json(ClienteForm clienteForm) throws JsonProcessingException {
       return  jsonMapper.writeValueAsString(clienteForm);
    }
}
