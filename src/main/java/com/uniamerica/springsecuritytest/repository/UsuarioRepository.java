package com.uniamerica.springsecuritytest.repository;

import com.uniamerica.springsecuritytest.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("from Usuario where username = :username ")
    public Usuario findByUsername(@Param("username")String username);
}
