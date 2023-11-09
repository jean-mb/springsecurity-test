package com.uniamerica.springsecuritytest.controller;

import com.uniamerica.springsecuritytest.entity.Usuario;
import com.uniamerica.springsecuritytest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService service;
    @GetMapping()
    public String rotaTodosUsuarios(){
        return "Rota para todos os logados";
    }
    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public String rotaUser(){
        return "Rota para os Users";
    }
    @GetMapping("/cliente")
    @PreAuthorize("hasAuthority('CLIENTE')")
    public String rotaCliente(){
        return "Rota para o Cliente";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String rotaAdmin(){
        return "Rota para o Admin";
    }
}
