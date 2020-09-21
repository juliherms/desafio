package com.compasso.desafio.conversor;

import org.springframework.stereotype.Component;

import com.compasso.desafio.dto.EstadoDTO;
import com.compasso.desafio.entities.Estado;

@Component
public class EstadoConversor extends ConversorBase<Estado, EstadoDTO> {

	@Override
	public EstadoDTO converterEntityToDto(Estado entity) {

		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(entity.getId());
		estadoDTO.setNome(entity.getNome());
		estadoDTO.setUf(entity.getUf());
		
		return estadoDTO;
	}

	@Override
	public Estado converterDtoToEntity(EstadoDTO dto) {
		
		Estado estado = new Estado();
		
		if(dto.getId() != null){
			estado.setId(dto.getId());
		}
		estado.setNome(dto.getNome());
		estado.setUf(dto.getUf());
		return estado;
	}

}
