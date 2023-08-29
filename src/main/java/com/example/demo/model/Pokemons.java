package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemons {
    @JsonProperty("name")
   private String name;

    @JsonProperty("stats")
    private Object[] stats;

    @JsonProperty("url")
    private String url;

    public void setStats(Object[] stats) {
        this.stats = stats;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object[] getStats() {
        return stats;
    }

    public void setUrl(Object[] stats) {
        this.stats = stats;
    }
}
