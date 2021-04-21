package com.orange.casacodigo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.casacodigo.controller.form.PaisForm;
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
public class PaisControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonMapper;

    @DisplayName("Deve retornar 200 ao cadastrar país")
    @Test
    void teste01() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/paises")
        .content(json(new PaisForm()))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }


    private String json(PaisForm paisForm) throws JsonProcessingException {
        paisForm.setNome("Brasil");
        return jsonMapper.writeValueAsString(paisForm);
    }
}
