package com.marcoscouto.resttemplate.client;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateClient {

    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }

}
