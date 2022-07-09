package com.compras.lista.compras.infrastructure.repositories;

import com.compras.lista.compras.domain.Item;
import com.compras.lista.compras.domain.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long> {

    List<Item> findByLista(Lista lista);
}
