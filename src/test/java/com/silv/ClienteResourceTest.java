package com.silv;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silv.domain.Cliente;
import com.silv.resources.ClienteResource;
import com.silv.service.ClienteService;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteResource.class)
public class ClienteResourceTest {
	
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	ClienteService clienteService;
	
	@Test
	public void listarClientes() throws Exception {
		Cliente cli1 = new Cliente(UUID.randomUUID(), "cli1","cli'",
				"cli@cli1.co",true);
		
		List<Cliente> clientes = new ArrayList<>();
		
		clientes.add(cli1);
		
		given(this.clienteService.listar()).willReturn(clientes);
		
		 this.mockMvc.perform(get("/api/clientes")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].nome", is(cli1.getNome())));
		
	}
	
	@Test
	public void salvarClientes() throws Exception {
		Cliente cli1 = new Cliente(UUID.randomUUID(), "cli1","cli'",
				"cli@cli1.co",true);
		
		given(this.clienteService.salvar(cli1)).willReturn(cli1);
		
		 this.mockMvc.perform(post("/api/clientes")
				 .contentType(MediaType.APPLICATION_JSON)
                 .content(objectMapper.writeValueAsString(cli1)))
				.andExpect(status().isCreated());
		
	}
	
}
