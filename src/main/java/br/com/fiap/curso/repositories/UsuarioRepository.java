package br.com.fiap.curso.repositories;

import br.com.fiap.curso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
