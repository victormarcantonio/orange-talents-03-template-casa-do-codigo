package com.orange.casacodigo.config;

import com.orange.casacodigo.controller.form.ClienteForm;
import com.orange.casacodigo.model.Estado;
import com.orange.casacodigo.model.Pais;
import com.orange.casacodigo.repository.EstadoRepository;
import com.orange.casacodigo.repository.PaisRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

public class ValidaEstadoPaisValidator implements ConstraintValidator<ValidaEstadoPais, ClienteForm> {

    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;

    public ValidaEstadoPaisValidator(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public void initialize(ValidaEstadoPais constraintAnnotation) {

    }

    @Override
    public boolean isValid(ClienteForm value, ConstraintValidatorContext context) {
       Optional<Pais> pais =paisRepository.findById(value.getPaisId());
       if(pais.isEmpty() ){
           return false;
       }
       List<Estado> estados = estadoRepository.findByPais(pais.get());
        if (!estados.isEmpty() && value.getEstadoId()==null) {
            return false;
        } else if (estados.isEmpty()) {
            return true;
        }
         for(Estado estado : estados){
             if (estado.getId() == value.getEstadoId()) {
                 return true;
             }
         }
         return false;
    }
}
