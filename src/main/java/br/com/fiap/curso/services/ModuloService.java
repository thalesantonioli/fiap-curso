package br.com.fiap.curso.services;

import java.util.Optional;

import br.com.fiap.curso.repositories.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.curso.entities.Modulo;

@Service
public class ModuloService {

	@Autowired
	private ModuloRepository moduloRepository;

	public Modulo create(Modulo modulo) {
		return moduloRepository.save(modulo);
	}

	public Modulo update(Modulo modulo) {
		if (!moduloRepository.existsById(modulo.getId())) {
			throw new RuntimeException("Módulo não encontrado");
		}
		
		return moduloRepository.save(modulo);
	}

	public void delete(Long id) {
		if (!moduloRepository.existsById(id)) {
			throw new RuntimeException("Módulo não encontrado");
		}
		
		moduloRepository.deleteById(id);
	}

	public Modulo find(Long id) {
		Optional<Modulo> optional = moduloRepository.findById(id);
		
		if (!optional.isPresent()) {
			throw new RuntimeException("Módulo não encontrado");
		}
		
		return optional.get();
	}
	
	public Page<Modulo> findAll(Pageable pageable){
		return moduloRepository.findAll(pageable);
	}
}
