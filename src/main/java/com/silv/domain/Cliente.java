package com.silv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private UUID id;

	@NotNull(message = "o campo nome não pode ser vazio")
	private String nome;

	@NotNull(message = "o campo sobrenome não pode ser vazio")
	private String sobrenome;

	@NotNull(message = "o campo email não pode ser vazio")
	@Email(message = "emal inválido")
	private String email;
	
	private boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Set<String> getTelefones() {
		return telefone;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefone = telefones;
	}

	public Cliente() {

	}

	@OneToMany(mappedBy = "cliente")
	private List<Venda> vendas = new ArrayList<>();

	public Cliente(UUID id, String nome, String sobrenome, String email, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.ativo = ativo;
	}

	public Set<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(Set<String> telefone) {
		this.telefone = telefone;
	}

	public List<Fornecedor> getFornecedor() {
		return Fornecedor;
	}

	public void setFornecedor(List<Fornecedor> fornecedor) {
		Fornecedor = fornecedor;
	}

	@ElementCollection
	private Set<String> telefone = new HashSet<>();

	@ManyToMany()
	@JoinTable(name = "fornecedor_cliente", joinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "fornecedor_id", referencedColumnName = "id"))
	private List<Fornecedor> Fornecedor = new ArrayList<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
