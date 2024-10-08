package com.nicollyreis.com.apiRest2.repositories;

import com.nicollyreis.com.apiRest2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario getUsuarioByEmail(String email);
}
