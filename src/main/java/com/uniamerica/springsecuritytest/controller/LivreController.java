package com.uniamerica.springsecuritytest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livre")
public class LivreController {
    @GetMapping
    public String teste(){
        return "<h1>livre</h1>";
    }
    @GetMapping("/oi")
    public String oi(){
        return "<h1>oi</h1>";
    }
}
