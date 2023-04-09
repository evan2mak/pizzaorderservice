package edu.iu.c322.pizzaorderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GreetingController {

    // Get http:localhost:8080
    @GetMapping
    public String greetings(){
        return "Greetings!";
    }
}
