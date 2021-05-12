package br.com.fiap.curso.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.curso.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	Page<Curso> findAll(Pageable pageable);
}
