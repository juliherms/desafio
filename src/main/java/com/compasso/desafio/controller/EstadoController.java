package com.compasso.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.desafio.controller.swagger.IEstadoController;
import com.compasso.desafio.dto.EstadoDTO;
import com.compasso.desafio.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController extends ControllerBase<EstadoDTO> implements IEstadoController {

	@Autowired
	private EstadoService service;

	@PostMapping
	public ResponseEntity<EstadoDTO> cadastrar(@RequestBody @Valid EstadoDTO estadoDTO, UriComponentsBuilder uriBuilder) {

		EstadoDTO dto = service.salvar(estadoDTO);
		String path = "/estados/{id}";

		return responderItemCriadoComURI(dto, uriBuilder, path, dto.getId().toString());
	}
}
