package com.orange.casacodigo.config;

import com.orange.casacodigo.controller.form.ClienteForm;
import com.orange.casacodigo.model.Estado;
import com.orange.casacodigo.model.Pais;
import com.orange.casacodigo.repository.EstadoRepository;
import com.orange.casacodigo.repository.PaisRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class PertenceAPaisValidator implements Validator {


    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;

    public PertenceAPaisValidator(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        ClienteForm request = (ClienteForm) target;
        if(request.temEstado()) {
            Pais pais = paisRepository.getOne(request.getPaisId());
            Estado estado = estadoRepository.getOne(request.getEstadoId());
            if (!estado.pertenceAPais(pais)) {
                errors.reject(null, "Estado não pertence ao país selecionado");
            }
        }
    }
}
