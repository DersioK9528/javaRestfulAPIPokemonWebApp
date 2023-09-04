package com.example.demo;

import com.example.demo.model.Pokemons;
import com.example.demo.model.PokemonsResponse;
import com.example.demo.rest.PokemonController;
import com.example.demo.service.PokemonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class PokemonRESTApiTests {

	@Mock
	private RestTemplate restTemplate;
    @Mock
	private PokemonService pokemonService;

	@Before
	public void mockPokemonService() {
		MockitoAnnotations.openMocks(this);
		pokemonService = new PokemonService(restTemplate);
	}
	@InjectMocks
	private PokemonController pokemonController;
	private MockMvc mockMvc;

	@Test
	public void testGetPokemonByName() throws Exception {
		// Create a sample Pokémon object
		Pokemons pikachu = new Pokemons();
		pikachu.setName("pikachu");

		// Mock the behavior of the PokemonService
		when(pokemonService.getPokemonByName("pikachu")).thenReturn(pikachu);

		// Initialize the MockMvc instance
		mockMvc = MockMvcBuilders.standaloneSetup(pokemonController).build();

		// Perform a GET request to retrieve a Pokémon by name
		mockMvc.perform(get("/pokemon-api/pokemons/pikachu")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("pikachu"));
	}

	@Test
	public void testGetPokemonsList() throws Exception {
		// Create a sample Pokémon list
		List<Pokemons> pokemonsList = new ArrayList<>();
		Pokemons bulbasaur = new Pokemons("bulbasaur", null, "https://pokeapi.co/api/v2/pokemon/1/", null);
		pokemonsList.add(bulbasaur);
		// Mock the behavior of the PokemonService
		PokemonsResponse mockResponse = new PokemonsResponse("100", "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20", null, pokemonsList);
		ResponseEntity<PokemonsResponse> mockResponseEntity = ResponseEntity.ok(mockResponse);

		when(pokemonService.getPokemonsListFromAPI()).thenReturn(mockResponse);

		// Initialize the MockMvc instance
		mockMvc = MockMvcBuilders.standaloneSetup(pokemonController).build();

		// Perform a GET request to retrieve a list of Pokémon
		mockMvc.perform(get("/pokemon-api/pokemons/")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.count").value("100"))
				.andExpect(jsonPath("$.results[0].name").value("bulbasaur"));
	}

	@Test
	public void testGetPokemonsListWithLimitAndOffset() throws Exception {
		// Create a mock PokemonsResponse matching the provided JSON
		String jsonResponse = "{\"count\":\"1281\",\"next\":\"https://pokeapi.co/api/v2/pokemon?offset=10&limit=10\",\"previous\":null,\"results\":[{\"name\":\"bulbasaur\",\"stats\":null,\"url\":\"https://pokeapi.co/api/v2/pokemon/1/\",\"types\":null},{\"name\":\"ivysaur\",\"stats\":null,\"url\":\"https://pokeapi.co/api/v2/pokemon/2/\",\"types\":null},{\"name\":\"venusaur\",\"stats\":null,\"url\":\"https://pokeapi.co/api/v2/pokemon/3/\",\"types\":null},{\"name\":\"charmander\",\"stats\":null,\"url\":\"https://pokeapi.co/api/v2/pokemon/4/\",\"types\":null},{\"name\":\"charmeleon\",\"stats\":null,\"url\":\"https://pokeapi.co/api/v2/pokemon/5/\",\"types\":null},{\"name\":\"charizard\",\"stats\":null,\"url\":\"https://pokeapi.co/api/v2/pokemon/6/\",\"types\":null},{\"name\":\"squirtle\",\"stats\":null,\"url\":\"https://pokeapi.co/api/v2/pokemon/7/\",\"types\":null},{\"name\":\"wartortle\",\"stats\":null,\"url\":\"https://pokeapi.co/api/v2/pokemon/8/\",\"types\":null},{\"name\":\"blastoise\",\"stats\":null,\"url\":\"https://pokeapi.co/api/v2/pokemon/9/\",\"types\":null},{\"name\":\"caterpie\",\"stats\":null,\"url\":\"https://pokeapi.co/api/v2/pokemon/10/\",\"types\":null}]}";
		ObjectMapper objectMapper = new ObjectMapper();
		PokemonsResponse mockResponse = objectMapper.readValue(jsonResponse, PokemonsResponse.class);

		// Mock the behavior of the Pokemon Service
		when(pokemonService.getPokemonsListFromAPIWithLimitAndOffset(10,0))
				.thenReturn(mockResponse);

		// Call the controller method
		PokemonsResponse result = pokemonController.getPokemonsListWithLimitAndOffset(10, 0);

		// Verify the response
		assertEquals(mockResponse, result);
	}
	@Test
	void contextLoads() {
	}

}
