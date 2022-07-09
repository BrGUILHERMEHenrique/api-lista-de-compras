package com.compras.lista.compras.service.controller;

import com.compras.lista.compras.application.dto.UsuarioLogin;
import com.compras.lista.compras.domain.Usuario;
import com.compras.lista.compras.service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({ "/usuario" })
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.findAll();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity save(@RequestBody Usuario usuario) throws Exception {
        return ResponseEntity.ok(usuarioService.createUsuario(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UsuarioLogin login){
        return ResponseEntity.ok("Login feuti cin sucesso");
    }
}
