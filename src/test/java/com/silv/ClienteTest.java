package com.silv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.UUID;

import org.aspectj.lang.annotation.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.silv.domain.Cliente;
import com.silv.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ClienteTest {

	@Autowired
	ClienteRepository repository;
	
	@After(value = "")
	public void after() {
		/*Cliente cliente = repository.findBynome("mauro teste");
		cliente.setAtivo(true);
		repository.save(cliente);*/
	}
	
	@Test
	public void desativarCliente() {
		Cliente cliente = repository.findBynome("mauro teste");
		
		cliente.setAtivo(false);
		repository.save(cliente);
		
		cliente = repository.findBynome("mauro teste");
		
		System.out.println("aqui" + cliente.isAtivo());
		
		assertFalse(cliente.isAtivo());
	}
	
	@Test
	public void retornarCLientePeloNome() {
		Cliente cliente = repository.findBynome("mauro teste");
		assertNotNull(cliente);
	}
	
	@Test
	public void retornaCLientesAtivos() {
		
		repository.save(new Cliente(UUID.randomUUID(),
				"mauro","lucio","mauro@mauro", true));
		
		List<Cliente> clientes = repository.listarAtivos();
		assertNotNull(clientes);
	}
	
}
