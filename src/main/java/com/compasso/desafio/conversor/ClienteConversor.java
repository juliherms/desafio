package com.compasso.desafio.conversor;

import org.springframework.stereotype.Component;

import com.compasso.desafio.dto.ClienteDTO;
import com.compasso.desafio.entities.Cliente;
import com.compasso.desafio.repository.CidadeRepository;

@Component
public class ClienteConversor extends ConversorBase<Cliente, ClienteDTO> {

	private CidadeRepository cidadeRepository;

	@Override
	public ClienteDTO converterEntityToDto(Cliente entity) {

		ClienteDTO clienteDTO = new ClienteDTO();

		clienteDTO.setCidade(entity.getCidade().getNome());
		clienteDTO.setDataNascimento(entity.getDataNascimento());
		clienteDTO.setEstado(entity.getCidade().getEstado().getUf());
		clienteDTO.setIdade(entity.getIdade());
		clienteDTO.setNome(entity.getNome());
		clienteDTO.setSexo(entity.getSexo());

		return clienteDTO;
	}

	@Override
	public Cliente converterDtoToEntity(ClienteDTO dto) {

		Cliente cliente = new Cliente();

		cliente.setCidade(cidadeRepository.findByNome(dto.getCidade()));
		cliente.setDataNascimento(dto.getDataNascimento());
		cliente.setIdade(dto.getIdade());
		cliente.setNome(dto.getNome());
		cliente.setSexo(dto.getSexo());

		return cliente;
	}
}