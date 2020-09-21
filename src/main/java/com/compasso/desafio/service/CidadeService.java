package com.compasso.desafio.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.compasso.desafio.conversor.CidadeConversor;
import com.compasso.desafio.dto.CidadeDTO;
import com.compasso.desafio.entities.Cidade;
import com.compasso.desafio.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	@Autowired
	private CidadeConversor cidadeConversor;

	/**
	 * Metodo responsável por listar todas as cidades cadastradas no sistema
	 * 
	 * @param page
	 * @return
	 */
	public Page<Cidade> findAll(final Pageable page) {
		return repo.findAll(page);
	}

	/**
	 * Método responsável por salvar uma cidade no sistema.
	 * 
	 * @param cidadeDTO
	 * @return
	 */
	public CidadeDTO salvar(@Valid CidadeDTO cidadeDTO) {
		
		
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param nome
	 * @return
	 */
	public CidadeDTO findByNome(String nome) {

		return cidadeConversor.converterEntityToDto(repo.findByNome(nome));
	}

}
