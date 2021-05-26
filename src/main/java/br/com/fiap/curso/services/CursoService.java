package br.com.fiap.curso.services;

import java.util.Optional;

import br.com.fiap.curso.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.curso.entities.Curso;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public Curso create(Curso curso) {
		return cursoRepository.save(curso);
	}

	public Curso update(Curso curso) {
		if (!cursoRepository.existsById(curso.getId())) {
			throw new RuntimeException("Curso não encontrado");
		}
		
		return cursoRepository.save(curso);
	}

	public void delete(Long id) {
		if (!cursoRepository.existsById(id)) {
			throw new RuntimeException("Curso não encontrado");
		}
		
		cursoRepository.deleteById(id);
	}

	public Curso find(Long id) {
		Optional<Curso> optional = cursoRepository.findById(id);
		
		if (!optional.isPresent()) {
			throw new RuntimeException("Curso não encontrado");
		}
		
		return optional.get();
	}

	public Curso findByNome(String nome) {
		Optional<Curso> optional = cursoRepository.findByNome(nome);

		if (!optional.isPresent()) {
			throw new RuntimeException("Curso não encontrado");
		}

		return optional.get();
	}
	
	public Page<Curso> findAll(Pageable pageable){
		return cursoRepository.findAll(pageable);
	}
}
