package com.compasso.desafio.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.compasso.desafio.dto.CidadeDTO;
import com.compasso.desafio.entities.Cidade;
import com.compasso.desafio.repository.EstadoRepository;

@Component
public class CidadeConversor extends ConversorBase<Cidade, CidadeDTO> {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public CidadeDTO converterEntityToDto(Cidade entity) {

		CidadeDTO cidadeDTO = new CidadeDTO();
		cidadeDTO.setId(entity.getId());
		cidadeDTO.setNome(entity.getNome());

		if (entity.getEstado() != null) {
			cidadeDTO.setEstado(entity.getEstado().getNome());
			cidadeDTO.setUf(entity.getEstado().getUf());
			cidadeDTO.setIdEstado(entity.getEstado().getId());
		}
		return cidadeDTO;
	}

	@Override
	public Cidade converterDtoToEntity(CidadeDTO dto) {

		Cidade cidade = new Cidade();
		cidade.setId(dto.getId());
		cidade.setNome(dto.getNome().toLowerCase());

		if (dto.getIdEstado() != null) {
			cidade.setEstado(estadoRepository.getOne(dto.getIdEstado()));
		}
		return cidade;
	}

}