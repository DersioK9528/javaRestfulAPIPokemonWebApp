package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the details of a Pokémon.
 */
public class Pokemons {

    @JsonProperty("name")
    private String name;

    @JsonProperty("stats")
    private Object[] stats;

    @JsonProperty("url")
    private String url;

    @JsonProperty("types")
    private Object[] types;

    public Pokemons(String name, Object[] stats, String url, Object[] types) {
        this.name = name;
        this.stats = stats;
        this.url = url;
        this.types = types;
    }

    public Pokemons() {
    }

    /**
     * Gets the URL of the Pokémon.
     *
     * @return The URL of the Pokémon.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL of the Pokémon.
     *
     * @param url The URL of the Pokémon.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the name of the Pokémon.
     *
     * @return The name of the Pokémon.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Pokémon.
     *
     * @param name The name of the Pokémon.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the statistics of the Pokémon.
     *
     * @return The statistics of the Pokémon.
     */
    public Object[] getStats() {
        return stats;
    }

    /**
     * Sets the statistics of the Pokémon.
     *
     * @param stats The statistics of the Pokémon.
     */
    public void setStats(Object[] stats) {
        this.stats = stats;
    }

    /**
     * Gets the types of the Pokémon.
     *
     * @return The types of the Pokémon.
     */
    public Object[] getTypes() {
        return types;
    }

    /**
     * Sets the types of the Pokémon.
     *
     * @param types The types of the Pokémon.
     */
    public void setTypes(Object[] types) {
        this.types = types;
    }
}
