package com.example.demo.service;

import com.example.demo.model.Pokemons;
import com.example.demo.model.PokemonsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("pokemonService")
public class PokemonService implements IPokemonService{

    RestTemplate restTemplate = new RestTemplate();
    @Override
    public PokemonsResponse getPokemonsListFromAPI() {

        String url = "https://pokeapi.co/api/v2/pokemon";

        ResponseEntity<PokemonsResponse> response = restTemplate.getForEntity(url, PokemonsResponse.class);
        PokemonsResponse pokemonsResponses = response.getBody();

        return pokemonsResponses;
    }
    @Override
    public Pokemons getPokemonByName(String name) {

        String url = "https://pokeapi.co/api/v2/pokemon/" + name;

        ResponseEntity<Pokemons> response = restTemplate.getForEntity(url, Pokemons.class);
        return response.getBody();
    }

    @Override
    public PokemonsResponse getPokemonsListFromAPIWithLimitAndOffset(int limit, int offset) {
        String url = "https://pokeapi.co/api/v2/pokemon?limit=" + limit + "&offset=" + offset;

        ResponseEntity<PokemonsResponse> response = restTemplate.getForEntity(url, PokemonsResponse.class);
        PokemonsResponse pokemonsResponses = response.getBody();

        return pokemonsResponses;
    }
}
