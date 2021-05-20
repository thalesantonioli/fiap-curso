package br.com.fiap.curso.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.curso.entities.Curso;
import br.com.fiap.curso.enums.CursoNivel;

public class CursoServiceTests {

	@Autowired
	private CursoService cursoService;
	
	@Test
	private void create() {
		Curso curso = new Curso();
		
		curso.setNivel(CursoNivel.IVANCADO);
		curso.setNome("Especialista JPA");
		curso.setDescricao("Treinamento imersivo focado em back-end, do básico ao ultra avançado sobre REST APIs com Spring.");
		curso.setPrecoOriginal(100d);
		curso.setPrecoPromocional(90d);
		
		cursoService.create(curso);
	}
}
