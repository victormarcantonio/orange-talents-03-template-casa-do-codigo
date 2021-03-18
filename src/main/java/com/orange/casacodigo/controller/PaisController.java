package com.orange.casacodigo.controller;

import com.orange.casacodigo.controller.form.PaisForm;
import com.orange.casacodigo.model.Pais;
import com.orange.casacodigo.repository.PaisRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public String cadastrar(@RequestBody @Valid PaisForm form){
       Pais pais = new Pais(form.getNome());
       paisRepository.save(pais);
       return pais.toString();
    }
}
