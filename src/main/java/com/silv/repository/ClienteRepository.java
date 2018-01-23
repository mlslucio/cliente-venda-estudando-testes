package com.silv.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.silv.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
	
	@Transactional
	@Modifying
	@Query("update Cliente cliente set cliente.ativo = false where cliente.id = :id")
	public void deletarCliente(@Param("id") UUID id);
	
	@Transactional
	@Query("select cliente from Cliente cliente where cliente.ativo = true")
	public List<Cliente> listarAtivos();
	
	public Cliente findBynome(String nome);
	
	
	
}
