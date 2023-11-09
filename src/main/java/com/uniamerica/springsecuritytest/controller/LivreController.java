package com.uniamerica.springsecuritytest.controller;

import com.uniamerica.springsecuritytest.entity.Role;
import com.uniamerica.springsecuritytest.entity.Usuario;
import com.uniamerica.springsecuritytest.repository.UsuarioRepository;
import com.uniamerica.springsecuritytest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livre")
public class LivreController {
    @Autowired
    UsuarioService service;

    @GetMapping("/teste")
    public String testeLivre(){
        return "Rota Livre";
    }
    @GetMapping("/configurar")
    public String configurarAdmin(){
        service.create(new Usuario("admin", "admin", Role.ADMIN));
        return "<h3>Admin configurado!</h3><br><p>Usuario: admin - Senha: admin";
    }
}
