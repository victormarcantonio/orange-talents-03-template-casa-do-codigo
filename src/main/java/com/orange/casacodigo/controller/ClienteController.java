package com.orange.casacodigo.controller;

import com.orange.casacodigo.config.PertenceAPaisValidator;
import com.orange.casacodigo.controller.form.ClienteForm;
import com.orange.casacodigo.model.Cliente;
import com.orange.casacodigo.repository.ClienteRepository;
import com.orange.casacodigo.repository.EstadoRepository;
import com.orange.casacodigo.repository.PaisRepository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;
    private ClienteRepository clienteRepository;
    private PertenceAPaisValidator pertenceAPaisValidator;


    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(pertenceAPaisValidator);
    }

    public ClienteController(PaisRepository paisRepository, EstadoRepository estadoRepository, ClienteRepository clienteRepository, PertenceAPaisValidator pertenceAPaisValidator) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.clienteRepository = clienteRepository;
        this.pertenceAPaisValidator = pertenceAPaisValidator;
    }

    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid ClienteForm form){
        Cliente cliente = form.converter(paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        return cliente.toString();
    }
}
