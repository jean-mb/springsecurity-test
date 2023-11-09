package com.uniamerica.springsecuritytest.service;

import com.uniamerica.springsecuritytest.entity.Role;
import com.uniamerica.springsecuritytest.entity.Usuario;
import com.uniamerica.springsecuritytest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    UsuarioRepository repository;
    @Autowired
    PasswordEncoder encoder;

    public Usuario getByUsername(String username){
        return repository.findByUsername(username);
    }

    @Transactional
    public Usuario create(Usuario usuario){
        Assert.isNull(getByUsername(usuario.getUsername()), "Usuario já existe!");
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }

    public List<Usuario> getAll(){
        return repository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
        return usuario;
    }
}
