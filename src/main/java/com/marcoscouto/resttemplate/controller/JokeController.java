package com.marcoscouto.resttemplate.controller;

import com.marcoscouto.resttemplate.data.ChuckNorrisJoke;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping()
public class JokeController {

    private final RestTemplate template;

    public JokeController(RestTemplate template) {
        this.template = template;
    }

    @GetMapping("/joke")
    public ResponseEntity response(){
        ChuckNorrisJoke response = template.getForObject("https://api.chucknorris.io/jokes/random", ChuckNorrisJoke.class);
        return ResponseEntity.ok(response.getJoke());
    }

}
