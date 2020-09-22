package com.compasso.desafio.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.compasso.desafio.conversor.CidadeConversor;
import com.compasso.desafio.dto.CidadeDTO;
import com.compasso.desafio.entities.Cidade;
import com.compasso.desafio.entities.Estado;
import com.compasso.desafio.repository.CidadeRepository;
import com.compasso.desafio.repository.EstadoRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	@Autowired
	private EstadoRepository estadoRepository;

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
		
		
		Estado estado = verificarEstado(cidadeDTO);
		
		Cidade cidade = cidadeConversor.converterDtoToEntity(cidadeDTO);
		cidade.setEstado(estado);
		
		repo.save(cidade);
		
		return cidadeConversor.converterEntityToDto(cidade);
		
	}
	
	private Estado verificarEstado(CidadeDTO cidadeDTO) {
		
		Estado estado = new Estado();
		
		
		if(!cidadeDTO.getEstado().isEmpty() && !cidadeDTO.getUf().isEmpty()){
			estado.setNome(cidadeDTO.getEstado());
			estado.setUf(cidadeDTO.getUf());
			
			estadoRepository.save(estado);
			
		}
		
		return estado;
	}

	/**
	 * 
	 * @param nome
	 * @return
	 */
	public CidadeDTO findByNome(String nome) {

		return cidadeConversor.converterEntityToDto(repo.findByNome(nome.toLowerCase()));
	}

}
