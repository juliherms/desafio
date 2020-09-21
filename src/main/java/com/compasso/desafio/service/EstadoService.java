package com.compasso.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.compasso.desafio.conversor.EstadoConversor;
import com.compasso.desafio.dto.EstadoDTO;
import com.compasso.desafio.entities.Estado;
import com.compasso.desafio.repository.EstadoRepository;

@Service
public class EstadoService {

	
	@Autowired
	private EstadoRepository repo;
	@Autowired
	private EstadoConversor estadoConversor;
	
	/**
	 * Metodo responsável por listar todos os estados cadastrados no sistema
	 * @param page
	 * @return
	 */
	public Page<Estado> findAll(final Pageable page) {
		return repo.findAll(page);
	}
	
	/**
	 * Metodo responsável por salvar um estado.
	 * @param dto
	 * @return
	 */
	public EstadoDTO salvar(EstadoDTO dto) {
		
		Estado estado = estadoConversor.converterDtoToEntity(dto);
		repo.save(estado);
		
		return estadoConversor.converterEntityToDto(estado);

	}

}
