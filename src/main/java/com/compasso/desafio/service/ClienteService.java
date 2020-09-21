package com.compasso.desafio.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.compasso.desafio.conversor.ClienteConversor;
import com.compasso.desafio.dto.ClienteDTO;
import com.compasso.desafio.entities.Cliente;
import com.compasso.desafio.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	@Autowired
	private ClienteConversor clienteConversor;

	/**
	 * Metodo responsável por listar todos os clientes cadastrados no sistema
	 * 
	 * @param page
	 * @return
	 */
	public Page<Cliente> findAll(final Pageable page) {
		return repo.findAll(page);
	}

	public ClienteDTO salvar(ClienteDTO clienteDTO) {

		Cliente cliente = clienteConversor.converterDtoToEntity(clienteDTO);
		repo.save(cliente);

		return clienteConversor.converterEntityToDto(cliente);

	}

	public void deletar(Long id) {
		repo.deleteById(id);

	}

	public ClienteDTO consultar(Long id) {
		Cliente cliente = repo.findById(id).get();
		return clienteConversor.converterEntityToDto(cliente);
	}

	public void atualizar(@Valid ClienteDTO clienteDTO, Long id) {

		Optional<Cliente> optional = repo.findById(id);

		if (optional.isPresent()) {
			Cliente cliente = optional.get();
			cliente.setNome(clienteDTO.getNome());
			repo.save(cliente);
		}
	}

	public ClienteDTO consultar(String nome) {
		Cliente cliente = repo.findByNome(nome);
		return clienteConversor.converterEntityToDto(cliente);
	}

}
