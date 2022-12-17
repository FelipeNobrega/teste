package br.com.produto.rest.external;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
@EnableFeignClients(basePackages = "br.com.produto.rest.external")
public class FeignConfiguration {
	
	@Bean
	public Logger.Level loggerLevel() {
		return Logger.Level.FULL;
	}

}
