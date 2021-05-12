package br.com.fiap.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.curso.entities.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {

}
