package br.com.fiap.curso.repositories;

import br.com.fiap.curso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario>  findByemail(String email);

    Optional<Usuario> findByNome(String nome);

}
