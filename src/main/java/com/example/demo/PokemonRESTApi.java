package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for starting the Pokémon REST API application.
 */
@SpringBootApplication
public class PokemonRESTApi {

	/**
	 * Main method to start the Pokémon REST API application.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PokemonRESTApi.class, args);
	}
}
