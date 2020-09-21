package com.compasso.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compasso.desafio.entities.Cidade;
import com.compasso.desafio.entities.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {


	/**
	 * Metodo responsável por retornar uma cidade por nome.
	 * @param nome
	 * @return
	 */
	Cidade findByNome(String nome);
	
	/**
	 * Metodo responsável por retornar uma lista de cidades por estado.
	 * @param estado
	 * @return
	 */
	List<Cidade> findByEstado(Estado estado);
}
