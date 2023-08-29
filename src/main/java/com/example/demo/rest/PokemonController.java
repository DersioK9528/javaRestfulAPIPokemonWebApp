package com.example.demo.rest;

import com.example.demo.model.Pokemons;
import com.example.demo.model.PokemonsResponse;
import com.example.demo.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.awt.*;

@RestController
@RequestMapping("/pokemon-api")
public class PokemonController {
    @Autowired
    private IPokemonService pokemonService;

    @RequestMapping(value="pokemons/", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public PokemonsResponse getPokemonsList(){
        PokemonsResponse pokemonsResponse;
        pokemonsResponse = pokemonService.getPokemonsListFromAPI();
        String totalItems = "100";
        pokemonsResponse.setCount(totalItems);
        return pokemonsResponse;
    }

    @RequestMapping(value = "pokemons/{name}", method = RequestMethod.GET,consumes = MediaType.ALL_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pokemons> getPokemonByName(@PathVariable String name) {
        // Implement logic to retrieve Pokémon by name from your service
        // You can use the 'name' parameter to fetch the specific Pokémon
        Pokemons pokemons;
        pokemons = pokemonService.getPokemonByName(name);
        if (pokemons != null) {
            return new ResponseEntity<>(pokemons, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        @RequestMapping(value = "/pokemons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public PokemonsResponse getPokemonsListWithLimitAndOffset(
                @RequestParam(name = "limit", defaultValue = "10") int limit,
                @RequestParam(name = "offset", defaultValue = "0") int offset) {
            // Add logic to apply the limit and offset to the API call
            PokemonsResponse pokemonsResponse = pokemonService.getPokemonsListFromAPIWithLimitAndOffset(limit, offset);
            return pokemonsResponse;
        }
}
