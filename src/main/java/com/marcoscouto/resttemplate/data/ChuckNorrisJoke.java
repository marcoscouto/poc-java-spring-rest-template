package com.marcoscouto.resttemplate.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChuckNorrisJoke {

    private String joke;

    @JsonProperty("joke")
    public String getJoke() {
        return joke;
    }

    @JsonProperty("value")
    public void setJoke(String joke) {
        this.joke = joke;
    }

}
