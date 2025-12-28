package com.bankymono.webflux_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(scanBasePackages = "com.bankymono.webflux_proj.${sec}")
@EnableR2dbcRepositories(basePackages = "com.bankymono.webflux_proj.${sec}")
public class WebfluxProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxProjApplication.class, args);
	}

}
