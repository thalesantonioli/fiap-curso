package br.com.fiap.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.curso.entities.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{

}
