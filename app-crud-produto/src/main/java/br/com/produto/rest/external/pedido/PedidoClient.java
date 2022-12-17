package br.com.produto.rest.external.pedido;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.produto.rest.entity.Produto;

@FeignClient(name = "PedidoClient", url = "http://localhost:8082/ped")
public interface PedidoClient {
	
	@PostMapping(value =  "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
	Produto createProduct(Produto request);

}
