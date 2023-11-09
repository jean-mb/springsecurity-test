package com.uniamerica.springsecuritytest.controller;

import com.uniamerica.springsecuritytest.entity.Usuario;
import com.uniamerica.springsecuritytest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    UsuarioService service;

    @GetMapping("/usuarios/todos")
    public ResponseEntity<List<Usuario>> getALl(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/usuarios/cadastrar")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(service.create(usuario));
    }
}
