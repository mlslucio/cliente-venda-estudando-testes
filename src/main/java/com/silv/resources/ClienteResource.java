package com.silv.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.silv.domain.Cliente;
import com.silv.service.ClienteService;

@CrossOrigin(maxAge = 360000)
@RestController
@RequestMapping("api/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteService service;
	
	@GetMapping
	@ResponseBody
	public List<Cliente> getClientes(){
		return  service.listar();
		
	}
	
	@GetMapping("/{id}")
	public Cliente getCliente(@PathVariable UUID id){
		return service.findById(id);
	}
	
	
	@PostMapping
	public ResponseEntity<?> insereCliente(@RequestBody Cliente obj){
		obj.setId(UUID.randomUUID());
		service.salvar(obj);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> alteraCliente(@RequestBody Cliente obj){
		service.salvar(obj);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarCliente(@PathVariable Cliente cliente){
		service.deletar(cliente);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
}
