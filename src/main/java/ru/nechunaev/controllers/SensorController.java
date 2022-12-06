package ru.nechunaev.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorController {

    @GetMapping("/hello")
    public String hello() {
        return "hello!";
    }
}
