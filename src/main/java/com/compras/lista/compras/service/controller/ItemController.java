package com.compras.lista.compras.service.controller;

import com.compras.lista.compras.domain.Item;
import com.compras.lista.compras.service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/item" })
public class ItemController {
    @Autowired
    ItemService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Item item){
        service.createItem(item);
        return ResponseEntity.ok("Item cadastrado com sucesso");
    }
}
