package br.com.pedido.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedido.rest.entity.PedidoProduto;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long>{

}
