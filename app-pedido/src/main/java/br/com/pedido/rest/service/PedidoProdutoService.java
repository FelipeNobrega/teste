package br.com.pedido.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedido.rest.entity.PedidoProduto;
import br.com.pedido.rest.repository.PedidoProdutoRepository;

@Service
public class PedidoProdutoService {
	
	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepository;
	
	public PedidoProduto save(PedidoProduto pedidoProduto) {
		return pedidoProdutoRepository.save(pedidoProduto);
	}

}
