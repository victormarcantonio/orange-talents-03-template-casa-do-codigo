package com.orange.casacodigo.controller;

import com.orange.casacodigo.controller.form.EstadoForm;
import com.orange.casacodigo.model.Estado;
import com.orange.casacodigo.repository.EstadoRepository;
import com.orange.casacodigo.repository.PaisRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/estados")
public class EstadoController {

    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;


    public EstadoController(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public String cadastrar(@RequestBody @Valid EstadoForm form){
        Estado estado = form.converter(paisRepository);
        estadoRepository.save(estado);
        return estado.toString();
    }
}
