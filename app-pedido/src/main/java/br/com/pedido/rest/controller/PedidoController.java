package br.com.pedido.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedido.rest.entity.Pedido;
import br.com.pedido.rest.service.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pedido findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedido));
	}
	

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Pedido update(@RequestBody Pedido pedido){
		return service.save(pedido);
	}
	
	public ResponseEntity<?> delete(Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}
