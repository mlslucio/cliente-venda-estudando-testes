package com.silv.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import com.silv.domain.Cliente;
import com.silv.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;

	public Cliente salvar(Cliente cliente) {
		cliente.setId(UUID.randomUUID());
		return this.repository.save(cliente);
	}

	public void alterar(Cliente cliente) {
		this.repository.save(cliente);
	}

	public List<Cliente> listar() {
		return repository.findAll();
		
	}

	public void deletar(Cliente cliente) {
		cliente.setAtivo(false);
		this.repository.save(cliente);
	}

	public Cliente findBynome(String nome) {
		return this.repository.findBynome(nome);
	}
	
	public Cliente findById(UUID id) {
		return this.repository.findOne(id);
	}

	public void save(Cliente cliente) {
		this.repository.save(cliente);

	}

}
