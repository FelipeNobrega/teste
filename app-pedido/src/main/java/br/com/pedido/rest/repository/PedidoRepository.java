package br.com.pedido.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedido.rest.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
