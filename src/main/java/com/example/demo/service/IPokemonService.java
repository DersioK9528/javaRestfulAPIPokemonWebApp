package com.example.demo.service;

import com.example.demo.model.Pokemons;
import com.example.demo.model.PokemonsResponse;

public interface IPokemonService {
    public PokemonsResponse getPokemonsListFromAPI();
    public Pokemons getPokemonByName(String name);

    public PokemonsResponse getPokemonsListFromAPIWithLimitAndOffset(int limit, int offset);
}
