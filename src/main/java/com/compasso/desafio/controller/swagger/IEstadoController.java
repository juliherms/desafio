package com.compasso.desafio.controller.swagger;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.desafio.dto.ErrorDTO;
import com.compasso.desafio.dto.EstadoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

/**
 * Classe responsável por documentar o endpoint de estados
 * 
 * @author j.a.vasconcelos
 *
 */
@Api(value = "/estados", description = "Endpoint responsável por manter os estados")
public interface IEstadoController {

	@ApiOperation(value = "Cadastrar Estado", nickname = "cadastrar", notes = "", response = EstadoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "estados" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Estado salvo com sucesso", response = EstadoDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Erro de Requisição", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Usuário sem acesso"),
			@ApiResponse(code = 404, message = "Método não encontrado") })
	@PostMapping
	public ResponseEntity<EstadoDTO> cadastrar(@RequestBody @Valid EstadoDTO estadoDTO,
			UriComponentsBuilder uriBuilder);
}
