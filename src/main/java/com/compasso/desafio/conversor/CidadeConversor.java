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
			cidadeDTO.setNome(entity.getEstado().getNome());
		}
		return cidadeDTO;
	}

	@Override
	public Cidade converterDtoToEntity(CidadeDTO dto) {

		Cidade cidade = new Cidade();
		cidade.setId(dto.getId());
		cidade.setNome(dto.getNome());

		if (dto.getIdEstado() > 0) {
			cidade.setEstado(estadoRepository.getOne(dto.getIdEstado()));
		}
		return cidade;
	}

}