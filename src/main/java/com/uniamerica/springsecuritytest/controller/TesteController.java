package com.uniamerica.springsecuritytest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TesteController {
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public String teste(){
        return "<h1>teste</h1>";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADM')")
    public String testeAdm(){
        return "<h1>teste</h1>";
    }
}
