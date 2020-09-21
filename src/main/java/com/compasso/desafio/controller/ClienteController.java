package com.compasso.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.desafio.controller.swagger.IClienteController;
import com.compasso.desafio.dto.ClienteDTO;
import com.compasso.desafio.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends ControllerBase<ClienteDTO> implements IClienteController {

	@Autowired
	private ClienteService service;

	@Override
	public ResponseEntity<ClienteDTO> cadastrar(@Valid ClienteDTO clienteDTO, UriComponentsBuilder uriBuilder) {

		ClienteDTO dto = service.salvar(clienteDTO);
		String path = "/clientes/{code}";

		return responderItemCriadoComURI(dto, uriBuilder, path, dto.getId().toString());
	}

	@Override
	public ResponseEntity<ClienteDTO> deletar(Long id) {
		service.deletar(id);

		return responderSucesso();
	}

	@Override
	public ResponseEntity<ClienteDTO> consultar(Long id) {

		ClienteDTO clienteDTO = service.consultar(id);

		return resourceCreadtedWithItem(clienteDTO);
	}

	@Override
	public ResponseEntity<ClienteDTO> consultar(String nome) {
		
		ClienteDTO clienteDTO = service.consultar(nome);
		return resourceCreadtedWithItem(clienteDTO);
	}

	@Override
	public ResponseEntity<ClienteDTO> atualizar(@Valid ClienteDTO clienteDTO, UriComponentsBuilder uriBuilder,
			Long id) {
		
		service.atualizar(clienteDTO, id);
		return responderSucesso();
		
	}

}
