package com.compras.lista.compras.infrastructure.repositories;

import com.compras.lista.compras.domain.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository  extends JpaRepository<Familia, Long> {

}
