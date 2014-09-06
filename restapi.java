package com.example.bcorcoran.teslock;

//Grabs RestTemplate from Rest API
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class teslaapi {

//Requesting data from the car
    public RestTemplate()
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    return restTemplate.postForObject(uri, advertisement, String.class);

//initial dummy tesla car data
    200(OK)
    Content-Type:application/json

    {
        "shift_state":null,          //
            "speed":null,                //
            "latitude":33.794839,        // degrees N of equator
            "longitude":-84.401593,      // degrees W of the prime meridian
            "heading":4,                 // integer compass heading, 0-359
            "gps_as_of":1359863204       // Unix timestamp of GPS fix
    }
}
