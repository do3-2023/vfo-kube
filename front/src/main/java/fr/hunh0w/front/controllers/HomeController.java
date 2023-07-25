package fr.hunh0w.front.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

@RestController
public class HomeController {

    @Value("${api.host}")
    private String host_api;

    private final RestTemplate restTemplate;

    public HomeController(){
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/")
    public ResponseEntity<String> getHome()  {
        String url = "http://"+host_api+":8080/hello";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }

    @GetMapping("/healthz")
    public ResponseEntity<String> getHealth(){
        String url = "http://"+host_api+":8080/healthz";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if(response.getStatusCode() == HttpStatusCode.valueOf(200)) return response;
        return ResponseEntity.internalServerError().build();
    }

}
