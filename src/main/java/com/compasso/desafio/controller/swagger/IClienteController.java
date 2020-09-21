package com.compasso.desafio.controller.swagger;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.desafio.dto.ClienteDTO;
import com.compasso.desafio.dto.ErrorDTO;
import com.compasso.desafio.dto.EstadoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(value = "/clientes", description = "Endpoint responsável por manter os clientes")
public interface IClienteController {

	@ApiOperation(value = "Cadastrar Cliente", nickname = "cadastrar", notes = "", response = ClienteDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "clientes" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente salvo com sucesso", response = ClienteDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Erro de Requisição", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Usuário sem acesso"),
			@ApiResponse(code = 404, message = "Método não encontrado") })
	@PostMapping
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteDTO clienteDTO,
			UriComponentsBuilder uriBuilder);

	@ApiOperation(value = "Remover Cliente", nickname = "remover", notes = "", response = ClienteDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "clientes" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente Removido com sucesso", response = ClienteDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Erro de Requisição", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Usuário sem acesso"),
			@ApiResponse(code = 404, message = "Método não encontrado") })

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> deletar(@PathVariable Long id);

	@ApiOperation(value = "Consultar por Id", nickname = "consultar", notes = "", response = ClienteDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "clientes" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Consultar cliente sucesso", response = ClienteDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Error de requisição", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Usuário sem acesso"),
			@ApiResponse(code = 404, message = "Cliente não encontrado") })
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> consultar(@PathVariable Long id);
	
	@ApiOperation(value = "Consultar por Nome", nickname = "consultar", notes = "", response = ClienteDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "clientes" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Consultar cliente sucesso", response = ClienteDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Error de requisição", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Usuário sem acesso"),
			@ApiResponse(code = 404, message = "Cliente não encontrado") })
	@GetMapping("/consultar/{nome}")
	public ResponseEntity<ClienteDTO> consultar(@RequestParam(value="nome") String nome);
	

	@ApiOperation(value = "Atualizar Cliente", nickname = "atualizar", notes = "", response = ClienteDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "clientes" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente atualizado com sucesso", response = ClienteDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Erro de Requisição", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Usuário sem acesso"),
			@ApiResponse(code = 404, message = "Método não encontrado") })
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> atualizar(@RequestBody @Valid ClienteDTO clienteDTO,
			UriComponentsBuilder uriBuilder,@PathVariable Long id);
}
