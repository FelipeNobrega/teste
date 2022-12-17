package br.com.pedido.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedido.rest.entity.Pedido;
import br.com.pedido.rest.exception.ResourceNotFoundException;
import br.com.pedido.rest.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No data found for this ID"));
	}
	
	public Pedido save(Pedido pedido) {
		return repository.save(pedido);
	}
	
	public Pedido update(Pedido pedido) {
		var entity = findById(pedido.getId());
		
		entity.setDataPedido(pedido.getDataPedido());
		entity.setLocal(pedido.getLocal());
		entity.setPedidoProduto(pedido.getPedidoProduto());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		var entity = findById(id);
		repository.delete(entity);
	}

}
