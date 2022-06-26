package com.compras.lista.compras.infrastructure.repositories;

import com.compras.lista.compras.domain.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long> {
}
