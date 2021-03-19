package com.orange.casacodigo.controller;

import com.orange.casacodigo.controller.form.ClienteForm;
import com.orange.casacodigo.model.Cliente;
import com.orange.casacodigo.repository.ClienteRepository;
import com.orange.casacodigo.repository.EstadoRepository;
import com.orange.casacodigo.repository.PaisRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;
    private ClienteRepository clienteRepository;


    public ClienteController(PaisRepository paisRepository, EstadoRepository estadoRepository, ClienteRepository clienteRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public String cadastrar(@RequestBody @Valid ClienteForm form){
        Cliente cliente = form.converter(paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        return cliente.toString();
    }
}
