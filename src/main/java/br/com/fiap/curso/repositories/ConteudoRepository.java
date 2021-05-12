package br.com.fiap.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.curso.entities.Conteudo;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {

}
