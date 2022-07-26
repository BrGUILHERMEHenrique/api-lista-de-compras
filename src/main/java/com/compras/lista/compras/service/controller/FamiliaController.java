package com.compras.lista.compras.service.controller;

import com.compras.lista.compras.domain.Familia;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> familiaPorId(@PathVariable Long id) throws NotFoundException {

        return ResponseEntity.accepted().body(service.findById(id));
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarFamilia(@RequestBody Familia familia) {
        service.createFamilia(familia);
        return ResponseEntity.ok("Familia cadastrada com sucesso");
    }

    @PostMapping("/finalizarCompras/{idLista}")
    public ResponseEntity<?> finalizarCompras(@PathVariable int idLista) throws NotFoundException {
        if(service.finalizarCompras(idLista)){
            return ResponseEntity.accepted().body("Lista finalizada e atualizada com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Nao foi possivel finalizar a comprar e criar uma lista nova.");
        }
    }
}
