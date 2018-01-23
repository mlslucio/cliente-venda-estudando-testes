package com.silv.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silv.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID> {

}
