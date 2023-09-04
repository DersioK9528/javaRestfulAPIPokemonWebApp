package com.example.demo.rest;

import com.example.demo.model.Pokemons;
import com.example.demo.model.PokemonsResponse;
import com.example.demo.service.IPokemonService;
import org.apache.tomcat.util.bcel.classfile.ConstantUtf8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing Pokémon data.
 */
@RestController
@RequestMapping("/pokemon-api")
public class PokemonController {

    @Autowired
    private IPokemonService pokemonService;

    /**
     * Retrieves a list of Pokémon with default limit and offset.
     *
     * @return The response containing a list of Pokémon.
     */
    @RequestMapping(value = "pokemons/", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PokemonsResponse getPokemonsList() {
        PokemonsResponse pokemonsResponse;
        pokemonsResponse = pokemonService.getPokemonsListFromAPI();
        String totalItems = "100";
        pokemonsResponse.setCount(totalItems);
        return pokemonsResponse;
    }

    /**
     * Retrieves a Pokémon by its name.
     *
     * @param name The name of the Pokémon to retrieve.
     * @return The response containing the Pokémon.
     */
    @RequestMapping(value = "pokemons/{name}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pokemons> getPokemonByName(@PathVariable String name) {
        Pokemons pokemons;
        pokemons = pokemonService.getPokemonByName(name);
        if (pokemons != null) {
            return new ResponseEntity<>(pokemons, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of Pokémon with specified limit and offset.
     *
     * @param limit  The maximum number of Pokémon to retrieve.
     * @param offset The starting index of the retrieved list.
     * @return The response containing a list of Pokémon.
     */
    @RequestMapping(value = "/pokemons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PokemonsResponse getPokemonsListWithLimitAndOffset(
            @RequestParam(name = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset) {
        PokemonsResponse pokemonsResponse = pokemonService.getPokemonsListFromAPIWithLimitAndOffset(limit, offset);
        return pokemonsResponse;
    }
}
