package com.uniamerica.springsecuritytest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UsuarioController {
    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String userPath(){
        return "<h1>USER</h1>";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admPath(){
        return "<h1>ADMIN</h1>";
    }
    @GetMapping("/cliente")
    @PreAuthorize("hasRole('CLIENTE')")
    public String clientePath(){
        return "<h1>CLIENTE</h1>";
    }
}
