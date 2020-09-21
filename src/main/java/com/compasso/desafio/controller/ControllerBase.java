package com.compasso.desafio.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public class ControllerBase<T> {

	/**
	 * Return HTTP Created with object.
	 * 
	 * @param object
	 * @return
	 */
	protected ResponseEntity<T> resourceCreadtedWithItem(T object) {
		return ResponseEntity.status(HttpStatus.CREATED).body(object);
	}

	protected ResponseEntity<T> responderItemCriadoComURI(T object, UriComponentsBuilder uriBuilder, String path,
			String codigo) {
		URI uri = uriBuilder.path(path).buildAndExpand(codigo).toUri();
		return ResponseEntity.created(uri).body(object);
	}

	protected ResponseEntity<T> responderItemNaoEncontrado() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	protected ResponseEntity<T> responderSucesso() {
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	protected ResponseEntity<T> responderSucessoComItem(T object) {
		return ResponseEntity.status(HttpStatus.OK).body(object);
	}

	protected ResponseEntity<List<T>> responderListaVazia() {
		List<T> listaVazia = new ArrayList<>();
		return ResponseEntity.status(HttpStatus.OK).body(listaVazia);
	}

	protected ResponseEntity<List<T>> resouceListOfItems(List<T> items) {
		return ResponseEntity.status(HttpStatus.OK).body(items);
	}

	protected ResponseEntity<T> responderRequisicaoMalSucedida() {
		return ResponseEntity.badRequest().build();
	}

	protected ResponseEntity<Page<T>> responderListaDeItensPaginada(Page<T> itens) {
		return ResponseEntity.status(HttpStatus.OK).body(itens);
	}
}
