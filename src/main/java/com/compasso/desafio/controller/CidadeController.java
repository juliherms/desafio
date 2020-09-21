package com.compasso.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.desafio.controller.swagger.ICidadeController;
import com.compasso.desafio.dto.CidadeDTO;
import com.compasso.desafio.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController extends ControllerBase<CidadeDTO> implements ICidadeController {

	@Autowired
	private CidadeService service;

	@Override
	public ResponseEntity<CidadeDTO> cadastrar(@Valid CidadeDTO cidadeDTO, UriComponentsBuilder uriBuilder) {

		CidadeDTO dto = service.salvar(cidadeDTO);
		String path = "/cidades/{id}";

		return responderItemCriadoComURI(dto, uriBuilder, path, dto.getId().toString());
	}

	@Override
	public ResponseEntity<CidadeDTO> consultar(String nome) {

		CidadeDTO dto = service.findByNome(nome);
		return resourceCreadtedWithItem(dto);
	}

}
