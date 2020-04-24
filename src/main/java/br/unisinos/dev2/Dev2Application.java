package br.unisinos.dev2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.unisinos.dev2.model"})
public class Dev2Application {

	public static void main(String[] args) {
		SpringApplication.run(Dev2Application.class, args);
	}

}
