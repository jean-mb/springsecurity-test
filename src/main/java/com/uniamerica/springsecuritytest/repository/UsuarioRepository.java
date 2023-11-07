package com.uniamerica.springsecuritytest.repository;

import com.uniamerica.springsecuritytest.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
