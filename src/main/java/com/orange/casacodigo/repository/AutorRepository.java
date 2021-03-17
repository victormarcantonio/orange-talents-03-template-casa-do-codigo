package com.orange.casacodigo.repository;

import com.orange.casacodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
    Optional<Autor>findByNome(String nome);
}
