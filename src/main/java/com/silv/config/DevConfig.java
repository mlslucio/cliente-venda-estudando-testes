package com.silv.config;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.silv.domain.Cliente;
import com.silv.domain.Fornecedor;
import com.silv.repository.ClienteRepository;
import com.silv.repository.FornecedorRepository;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	FornecedorRepository fornecedorRepository;
	/*
	@Bean
	public boolean init() {
		Cliente cliente = new Cliente(UUID.randomUUID(), "mauro",
				"lucio","mauro@mauro.com",true);
		Fornecedor fornecedor = new Fornecedor(UUID.randomUUID(), "google");
		
		cliente.getFornecedor().addAll(Arrays.asList(fornecedor));
		cliente.getTelefone().addAll(Arrays.asList("1231232132",
				"12313222"));
		
		fornecedorRepository.save(fornecedor);
		clienteRepository.save(cliente);
		
		return true;
		
	}*/
	
}
