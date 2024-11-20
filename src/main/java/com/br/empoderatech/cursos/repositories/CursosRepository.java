package com.br.empoderatech.cursos.repositories;

import com.br.empoderatech.cursos.domain.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursosRepository extends JpaRepository<Cursos, Long> {

    Optional<Cursos> findByNome(String nome);

}
