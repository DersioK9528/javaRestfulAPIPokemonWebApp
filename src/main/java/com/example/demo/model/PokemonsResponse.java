package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents the response containing a list of Pokémon details.
 */
public class PokemonsResponse {

    @JsonProperty("count")
    private String count;

    @JsonProperty("next")
    private String next;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    private List<Pokemons> results;

    /**
     * Gets the count of Pokémon in the response.
     *
     * @return The count of Pokémon.
     */
    public String getCount() {
        return count;
    }

    /**
     * Sets the count of Pokémon in the response.
     *
     * @param count The count of Pokémon.
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * Gets the URL for the next page of results.
     *
     * @return The URL for the next page of results.
     */
    public String getNext() {
        return next;
    }

    /**
     * Sets the URL for the next page of results.
     *
     * @param next The URL for the next page of results.
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * Gets the URL for the previous page of results.
     *
     * @return The URL for the previous page of results.
     */
    public String getPrevious() {
        return previous;
    }

    /**
     * Sets the URL for the previous page of results.
     *
     * @param previous The URL for the previous page of results.
     */
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    /**
     * Gets the list of Pokémon details.
     *
     * @return The list of Pokémon details.
     */
    public List<Pokemons> getResults() {
        return results;
    }

    /**
     * Sets the list of Pokémon details.
     *
     * @param results The list of Pokémon details.
     */
    public void setResults(List<Pokemons> results) {
        this.results = results;
    }
}
