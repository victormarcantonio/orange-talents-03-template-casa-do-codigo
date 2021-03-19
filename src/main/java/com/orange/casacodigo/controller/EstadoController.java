package com.orange.casacodigo.controller;

import com.orange.casacodigo.controller.dto.EstadoDto;
import com.orange.casacodigo.controller.form.ClienteForm;
import com.orange.casacodigo.controller.form.EstadoForm;
import com.orange.casacodigo.model.Estado;
import com.orange.casacodigo.model.Pais;
import com.orange.casacodigo.repository.EstadoRepository;
import com.orange.casacodigo.repository.PaisRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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

    @GetMapping("/{paisId}")
    public List<EstadoDto> listarEstados(@PathVariable Long paisId){
        Pais pais = paisRepository.getOne(paisId);
        List<Estado> estados = estadoRepository.findByPais(pais);
        return EstadoDto.listarEstadosPorPais(estados);
    }
}
