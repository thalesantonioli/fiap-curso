package br.com.fiap.curso.repositories;

import br.com.fiap.curso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.curso.entities.Carrinho;

import java.util.List;
import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{

    List<Carrinho> findByUsuario(Usuario usuario);

}
