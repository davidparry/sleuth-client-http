package com.davidparry.controller;

import com.davidparry.PropertyConfig;
import com.davidparry.service.LocalWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@CrossOrigin // So that javascript can be hosted elsewhere
public class Frontend {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LocalWorkService localWorkService;

    @Autowired
    PropertyConfig propertyConfig;

    @RequestMapping("/")
    public String callBackend() {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set("user_name", "a_value_1234");

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                propertyConfig.getBackendBaseUrl() + "/api/"
                        + localWorkService.doWorkFor(900),
                HttpMethod.GET,
                request,
                String.class,
                1
        );

        return response.getBody();

       // return restTemplate.getForObject(propertyConfig.getBackendBaseUrl() + "/api/"
       //         + localWorkService.doWorkFor(500), String.class);
    }

}
