package com.silv;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.silv.domain.Cliente;
import com.silv.domain.Venda;
import com.silv.repository.ClienteRepository;
import com.silv.repository.VendaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class VendaTest {

	@Autowired
	VendaRepository vendaRepository;
	@Autowired
	ClienteRepository clienteRepository;

	
	@Test
	public void testInsereVenda() {
		Cliente cliente = clienteRepository.findBynome("mauro teste");
		String data = LocalDate.now().toString(); 
		UUID id  = UUID.randomUUID();
		Venda venda = new Venda(id, 10.00, data);

		venda.setCliente(cliente);
		vendaRepository.save(venda);
		
		venda = vendaRepository.findOne(id);
		
		System.out.println(venda.getCliente().getNome());
		
		assertNotNull(venda);
		assertEquals(cliente, venda.getCliente());
		
	}
	
}
