package com.compasso.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compasso.desafio.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	/**
	 * Metodo responsável por retornar um cliente por nome.
	 * @param nome
	 * @return
	 */
	Cliente findByNome(String nome);
}
