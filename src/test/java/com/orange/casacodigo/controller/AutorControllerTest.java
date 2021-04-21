package com.orange.casacodigo.controller;

import com.orange.casacodigo.repository.PaisRepository;
import org.hamcrest.Matchers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.casacodigo.controller.form.AutorForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
 class AutorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonMapper;

    @Test
    void deveCadastrarAutor() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/autores")
        .content(json(new AutorForm("nome", "email@email.com", "descricao")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

    @DisplayName("Deve apresentar erro em caso de email nao válido")
    @Test
    void testeErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/autores")
              .content(json(new AutorForm("nome", "email", "descricao")))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }


    private String json(AutorForm autorForm) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(autorForm);
    }
}
