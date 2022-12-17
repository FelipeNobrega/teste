package br.com.pedido.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedido.rest.entity.Produto;
import br.com.pedido.rest.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

}
