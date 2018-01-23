package com.silv.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silv.domain.Fornecedor;
import com.silv.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	FornecedorRepository repository;
	
	public void salvar(Fornecedor fornecedor) {
		fornecedor.setId(UUID.randomUUID());
		this.repository.save(fornecedor);
	}

	public void alterar(Fornecedor fornecedor) {
		this.repository.save(fornecedor);
	}

	public void listar() {
		this.repository.findAll();
	}

	public void deletar(UUID id) {
		this.repository.delete(id);
	}
}
