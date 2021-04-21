package com.orange.casacodigo.controller;

import com.orange.casacodigo.controller.dto.AutorDto;
import com.orange.casacodigo.controller.form.AutorForm;
import com.orange.casacodigo.model.Autor;
import com.orange.casacodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form, UriComponentsBuilder uriBuilder) {
       Autor autor = form.converter();
       autorRepository.save(autor);
       URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
       return ResponseEntity.ok().body(new AutorDto(autor));
    }
}
