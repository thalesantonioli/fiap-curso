package br.com.fiap.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.curso.entities.Cupom;

public interface CupomRepository extends JpaRepository<Cupom, Long>{

}
