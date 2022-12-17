package br.com.produto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.produto.rest.entity.Produto;
import br.com.produto.rest.exception.ResourceNotFoundException;
import br.com.produto.rest.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No data found for this entity"));
	}
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	public Produto update(Produto produto) {
		var entity = findById(produto.getId());
		
		entity.setNome(produto.getNome());
		entity.setQuantidade(produto.getQuantidade());
		entity.setDescricao(produto.getDescricao());
		entity.setPreco(produto.getPreco());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		var entity = findById(id);
		repository.delete(entity);
	}

}
