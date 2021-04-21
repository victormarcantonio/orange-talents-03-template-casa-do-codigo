package com.orange.casacodigo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.casacodigo.controller.form.CategoriaForm;
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
class CategoriaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonMapper;

    @DisplayName("Deve cadastrar categoria")
    @Test
    void teste() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/categorias")
        .content(json(new CategoriaForm()))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @DisplayName("Não deve cadastrar em caso de categoria nula")
    @Test
    void teste02() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/categorias")
        .content("")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    private String json(CategoriaForm form) throws JsonProcessingException {
        form.setNome("nome");
        return jsonMapper.writeValueAsString(form);
    }

}
