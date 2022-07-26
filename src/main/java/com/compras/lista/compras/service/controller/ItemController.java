package com.compras.lista.compras.service.controller;

import com.compras.lista.compras.domain.Item;
import com.compras.lista.compras.infrastructure.exceptions.NotFoundException;
import com.compras.lista.compras.service.service.ItemService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({ "/item" })
public class ItemController {
    @Autowired
    ItemService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{idLista}")
    public ResponseEntity<?> recuperarTodos(@PathVariable Long idLista) throws NotFoundException {
        return ResponseEntity.ok(service.findByLista(idLista));
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Item item){
        service.createItem(item);
        return ResponseEntity.ok("Item cadastrado com sucesso");
    }

    @PatchMapping("/atualizar")
    public ResponseEntity<?> atualizar(@RequestBody Item item) throws NotFoundException {
        return ResponseEntity.ok(service.atualizar(item));
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<?> apagar(@PathVariable Long id){
        if(service.delete(id)){
            return ResponseEntity.accepted().body("Item apagado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Nao foi possivel apagar o item");
        }
    }
}
