package br.com.pedido.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AppPedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPedidoApplication.class, args);
	}

}
