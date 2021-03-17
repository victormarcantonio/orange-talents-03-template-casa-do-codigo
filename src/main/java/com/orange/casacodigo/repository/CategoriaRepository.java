package com.orange.casacodigo.repository;

import com.orange.casacodigo.model.Autor;
import com.orange.casacodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);
}
