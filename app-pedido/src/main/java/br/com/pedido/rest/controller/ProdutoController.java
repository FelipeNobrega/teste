package br.com.pedido.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedido.rest.entity.Produto;
import br.com.pedido.rest.service.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(produto));
	}

}
