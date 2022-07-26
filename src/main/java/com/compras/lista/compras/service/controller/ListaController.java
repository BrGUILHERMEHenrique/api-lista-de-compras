package com.compras.lista.compras.service.controller;

import com.compras.lista.compras.domain.Lista;
import com.compras.lista.compras.infrastructure.exceptions.NotFoundException;
import com.compras.lista.compras.service.service.ListaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({ "/lista" })
public class ListaController {

    @Autowired
    ListaService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> listaPorID(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarFamilia(@RequestBody Lista lista){
        return ResponseEntity.accepted().body(service.createLista(lista));
    }
}
