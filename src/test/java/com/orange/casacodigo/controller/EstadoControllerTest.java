package com.orange.casacodigo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.casacodigo.controller.form.EstadoForm;
import com.orange.casacodigo.model.Pais;
import com.orange.casacodigo.repository.PaisRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
public class EstadoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonMapper;

    @Autowired
    PaisRepository paisRepository;

    @BeforeEach
    public void init(){
        Pais pais = new Pais("Brasil");
        paisRepository.save(pais);
    }


    @DisplayName("Deve retornar 200 ao cadastrar estado")
    @Test
    void teste01() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/estados")
        .content(json(new EstadoForm("Sao Paulo",1L)))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    private String json(EstadoForm estadoForm) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(estadoForm);
    }
}
