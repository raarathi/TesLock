package com.example.bcorcoran.teslock;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.StringHttpMessageConverter;

public class Teslaapi {

    String url = "http://localhost:8080/mockTesla/vehicles/1234567890/command/drive_state";
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    String result = restTemplate.getForObject(url, String.class, "Android")
}
