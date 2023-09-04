package com.example.demo.service;

import com.example.demo.model.Pokemons;
import com.example.demo.model.PokemonsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service class for fetching Pokémon data from external APIs.
 */
@Service("pokemonService")
public class PokemonService implements IPokemonService {

    RestTemplate restTemplate = new RestTemplate();

    public PokemonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetch a list of Pokémon from the external API.
     *
     * @return The response containing a list of Pokémon.
     */
    @Override
    public PokemonsResponse getPokemonsListFromAPI() {
        String url = "https://pokeapi.co/api/v2/pokemon";
        ResponseEntity<PokemonsResponse> response = restTemplate.getForEntity(url, PokemonsResponse.class);
        PokemonsResponse pokemonsResponses = response.getBody();
        return pokemonsResponses;
    }

    /**
     * Fetch a Pokémon by its name from the external API.
     *
     * @param name The name of the Pokémon to fetch.
     * @return The Pokémon with the specified name.
     */
    @Override
    public Pokemons getPokemonByName(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        ResponseEntity<Pokemons> response = restTemplate.getForEntity(url, Pokemons.class);
        return response.getBody();
    }

    /**
     * Fetch a limited list of Pokémon from the external API with specified limit and offset.
     *
     * @param limit  The maximum number of Pokémon to fetch.
     * @param offset The starting index for fetching Pokémon.
     * @return The response containing a limited list of Pokémon.
     */
    @Override
    public PokemonsResponse getPokemonsListFromAPIWithLimitAndOffset(int limit, int offset) {
        String url = "https://pokeapi.co/api/v2/pokemon?limit=" + limit + "&offset=" + offset;
        ResponseEntity<PokemonsResponse> response = restTemplate.getForEntity(url, PokemonsResponse.class);
        PokemonsResponse pokemonsResponses = response.getBody();
        return pokemonsResponses;
    }
}
