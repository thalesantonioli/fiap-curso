package br.com.fiap.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.curso.entities.Carrinho;
import br.com.fiap.curso.repositories.CarrinhoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;

	public Carrinho create(Carrinho carrinho) {
		return carrinhoRepository.save(carrinho);		
	}

	public Carrinho update(Carrinho carrinho) {
		if (!carrinhoRepository.existsById(carrinho.getId())) {
			throw new RuntimeException("Carrinho não encontrado");
		}
		
		return carrinhoRepository.save(carrinho);
	}
	
	public void delete(Long id) {
		if (!carrinhoRepository.existsById(id)) {
			throw new RuntimeException("Carrinho não encontrado");
		}
		
		carrinhoRepository.deleteById(id);
	}
	
	public Carrinho find(Long id) {
		Optional<Carrinho> optional = carrinhoRepository.findById(id);
		
		if (!optional.isPresent()) {
			throw new RuntimeException("Módulo não encontrado");
		}
		
		return optional.get();
	}
	
	public Page<Carrinho> findAll(Pageable pageable) {
		return carrinhoRepository.findAll(pageable);
	}
}
