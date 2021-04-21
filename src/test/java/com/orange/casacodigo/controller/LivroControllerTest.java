package com.orange.casacodigo.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.casacodigo.controller.form.LivroForm;
import com.orange.casacodigo.model.Autor;
import com.orange.casacodigo.model.Categoria;
import com.orange.casacodigo.model.Livro;
import com.orange.casacodigo.repository.AutorRepository;
import com.orange.casacodigo.repository.CategoriaRepository;
import com.orange.casacodigo.repository.LivroRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
public class LivroControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonMapper;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    LivroRepository livroRepository;

    @DisplayName("Deve cadastrar livro")
    @Test
    void teste01() throws Exception {
        Autor autor = new Autor("victor", "victor@email.com", "autor livros policiais");
        Categoria categoria = new Categoria("Spring");
        autorRepository.save(autor);
        categoriaRepository.save(categoria);
        mockMvc.perform(MockMvcRequestBuilders.post("/livros")
        .content(json(new LivroForm("teste", "teste", "123", new BigDecimal("20.0"), 123, "1234", 1L, 1L)))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @DisplayName("Deve listar livros")
    @Test
    void teste02() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/livros"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @DisplayName("Deve trazer detalhes do livro")
    @Test
    void teste03() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/livros/"+ 1L))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @DisplayName("Deve retornar 404 caso o livro não exista")
    @Test
    void teste04() throws Exception {
        livroRepository.deleteById(1L);
        mockMvc.perform(MockMvcRequestBuilders.get("/livros/" + 1L))
                .andExpect(MockMvcResultMatchers.status().is(404));
    }

    public String json(LivroForm form) throws JsonProcessingException {
       return jsonMapper.writeValueAsString(form);
    }
}
