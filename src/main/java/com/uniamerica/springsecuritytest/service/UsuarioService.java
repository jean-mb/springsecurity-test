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

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    UsuarioRepository repository;
    @Autowired
    PasswordEncoder encoder;

    @Transactional
    public void demoCreate(){
        Usuario admin = new Usuario();
        Usuario user = new Usuario();
        Usuario cliente = new Usuario();

        admin.setUsername("admin");
        admin.setSenha(encoder.encode("admin"));
        admin.setRole(Role.ADMIN);

        user.setUsername("user");
        user.setSenha(encoder.encode("user"));
        user.setRole(Role.USER);

        cliente.setUsername("cliente");
        cliente.setSenha(encoder.encode("cliente"));
        cliente.setRole(Role.CLIENTE);

        repository.save(admin);
        repository.save(user);
        repository.save(cliente);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }

        return User.withUsername(usuario.getUsername())
                .password(usuario.getSenha())
                .roles(String.valueOf(usuario.getRole()))
                .build();
    }
}
