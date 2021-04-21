package com.orange.casacodigo.repository;

import com.orange.casacodigo.model.Estado;
import com.orange.casacodigo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado>findByPais(Pais pais);

}
