package com.compras.lista.compras.infrastructure.repositories;

import com.compras.lista.compras.domain.item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<item, Long> {
}
