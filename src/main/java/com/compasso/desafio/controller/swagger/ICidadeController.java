package com.compasso.desafio.controller.swagger;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.desafio.dto.CidadeDTO;
import com.compasso.desafio.dto.ErrorDTO;
import com.compasso.desafio.dto.EstadoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

/**
 * Classe responsável por documentar o endpoint de cidades
 * 
 * @author j.a.vasconcelos
 *
 */
@Api(value = "/cidades", description = "Endpoint responsável por manter as cidades")
public interface ICidadeController {

	@ApiOperation(value = "Cadastrar Cidade", nickname = "cadastrar", notes = "", response = CidadeDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "cidades" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cidade salva com sucesso", response = EstadoDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Erro de Requisição", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Usuário sem acesso"),
			@ApiResponse(code = 404, message = "Método não encontrado") })
	@PostMapping
	public ResponseEntity<CidadeDTO> cadastrar(@RequestBody @Valid CidadeDTO cidadeDTO,
			UriComponentsBuilder uriBuilder);
	
	
	@ApiOperation(value = "Consultar por Nome", nickname = "consultar", notes = "", response = CidadeDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "cidades" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Consultar cidade sucesso", response = CidadeDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Error de requisição", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Usuário sem acesso"),
			@ApiResponse(code = 404, message = "Método não encontrada") })
	@GetMapping("/{nome}")
	public ResponseEntity<CidadeDTO> consultar(@PathVariable String nome);


}
