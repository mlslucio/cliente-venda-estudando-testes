package com.silv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private UUID id;
	private String nome;

	public Fornecedor() {

	}

	public Fornecedor(UUID id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@JsonIgnore
	@ManyToMany()
	@JoinTable(name = "fornecedor_cliente", joinColumns = @JoinColumn(name = "fornecedor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "id"))
	private List<Cliente> cliente = new ArrayList<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

}
