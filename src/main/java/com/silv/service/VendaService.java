package com.silv.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silv.domain.Venda;
import com.silv.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	VendaRepository repository;

	public void salvar(Venda venda) {
		venda.setId(UUID.randomUUID());
		this.repository.save(venda);
	}

	public void alterar(Venda venda) {
		this.repository.save(venda);
	}

	public void listar() {
		this.repository.findAll();
	}

	public void deletar(UUID id) {
		this.repository.delete(id);
	}
}
