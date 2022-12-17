package br.com.produto.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.rest.entity.Produto;
import br.com.produto.rest.external.pedido.PedidoClient;
import br.com.produto.rest.service.ProdutoService;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/getPort")
	public String getPort() {
		return port;
	}
	
	@Autowired
	private ProdutoService service;
	
	@Autowired
	private PedidoClient pedidoClient;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Produto findById(@PathVariable(name = "id")Long id) {
		return service.findById(id);
	}
	
	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		pedidoClient.createProduct(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(produto));
	}
	
	@PutMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public Produto update(@RequestBody Produto produto) {
		return service.save(produto);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
