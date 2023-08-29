package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonsResponse {
    @JsonProperty("count")
    private String count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("results")
    private List<Pokemons> results;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Pokemons> getResults() {
        return results;
    }

    public void setResults(List<Pokemons> results) {
        this.results = results;
    }
}
