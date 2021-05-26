package br.com.fiap.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.curso.entities.Cupom;
import br.com.fiap.curso.repositories.CupomRepository;

@Service
public class CupomService {

	@Autowired
	private CupomRepository cupomRepository;
	
	public Cupom create(Cupom cupom) {
		return cupomRepository.save(cupom);
	}
	
	public Cupom update(Cupom cupom) {
		if (!cupomRepository.existsById(cupom.getId())) {
			throw new RuntimeException("Cupom não encontrado");
		}
		
		return cupomRepository.save(cupom);
	}
	
	public void delete(Long id) {
		if (!cupomRepository.existsById(id)) {
			throw new RuntimeException("Cupom não encontrado");
		}
		
		cupomRepository.deleteById(id);
	}
	
	public Cupom find(Long id) {
		Optional<Cupom> optional = cupomRepository.findById(id);
		
		if (!optional.isPresent()) {
			throw new RuntimeException("Cupom não encontrado");
		}
		
		return optional.get();
	}
	
	public Page<Cupom> findAll(Pageable pageable) {
		return cupomRepository.findAll(pageable);
	}
}
