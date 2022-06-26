package com.compras.lista.compras.infrastructure.repositories;

import com.compras.lista.compras.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Override
    List<Usuario> findAll();

    @Override
    <S extends Usuario> S save(S entity);
}
