package com.marcoscouto.resttemplate.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChuckNorrisJoke {

    @JsonProperty("value")
    private String joke;

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

}
