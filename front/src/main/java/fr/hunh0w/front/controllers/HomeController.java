package fr.hunh0w.front.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

@Controller
public class HomeController {

    @Value("${api.host}")
    private String host_api;

    @GetMapping("/")
    public String getHome() throws URISyntaxException {

        return "index";
    }

}
