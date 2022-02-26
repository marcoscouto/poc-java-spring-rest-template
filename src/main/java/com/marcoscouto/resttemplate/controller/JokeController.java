package com.marcoscouto.resttemplate.controller;

import com.marcoscouto.resttemplate.data.ChuckNorrisJoke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

@RestController
@RequestMapping()
public class JokeController {

    private final RestTemplate template;
    private final String baseUrl = "https://api.chucknorris.io/jokes/random";
    Logger logger = LoggerFactory.getLogger(JokeController.class);

    public JokeController(RestTemplate template) {
        this.template = template;
    }

    @GetMapping("/joke")
    public ResponseEntity response() {
        // var response = template.getForObject(baseUrl, ChuckNorrisJoke.class);
        return resolve(() -> template.getForEntity(baseUrl, ChuckNorrisJoke.class));
    }

    private ResponseEntity resolve(Callable<ResponseEntity> callable) {
        try {
            return callable.call();
        } catch (Exception e) {
            logger.warn("integration error: {}", e.getMessage());
            return ResponseEntity.unprocessableEntity().build();
        }
    }

}
