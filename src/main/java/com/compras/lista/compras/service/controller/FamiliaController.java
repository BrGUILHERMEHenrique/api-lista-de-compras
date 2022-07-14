package com.compras.lista.compras.service.controller;

import com.compras.lista.compras.infrastructure.exceptions.NotFoundException;
import com.compras.lista.compras.service.service.FamiliaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({ "/familia" })
public class FamiliaController {

    @Autowired
    FamiliaService service;

    @PostMapping("/finalizarCompras/{id}")
    public ResponseEntity<?> finalizarCompras(@PathVariable int id) throws NotFoundException {
        if(service.finalizarCompras(id)){
            return ResponseEntity.accepted().body("Lista finalizada e atualizada com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Nao foi possivel finalizar a comprar e criar uma lista nova.");
        }
    }
}
