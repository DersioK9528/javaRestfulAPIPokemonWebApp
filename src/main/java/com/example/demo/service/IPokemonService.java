package com.example.demo.service;

import com.example.demo.model.Pokemons;
import com.example.demo.model.PokemonsResponse;

/**
 * Interface for fetching Pokémon data from external APIs.
 */
public interface IPokemonService {

    /**
     * Fetch a list of Pokémon from an external API.
     *
     * @return The response containing a list of Pokémon.
     */
    PokemonsResponse getPokemonsListFromAPI();

    /**
     * Fetch a Pokémon by its name from an external API.
     *
     * @param name The name of the Pokémon to fetch.
     * @return The Pokémon with the specified name.
     */
    Pokemons getPokemonByName(String name);

    /**
     * Fetch a limited list of Pokémon from an external API with specified limit and offset.
     *
     * @param limit  The maximum number of Pokémon to fetch.
     * @param offset The starting index for fetching Pokémon.
     * @return The response containing a limited list of Pokémon.
     */
    PokemonsResponse getPokemonsListFromAPIWithLimitAndOffset(int limit, int offset);
}
