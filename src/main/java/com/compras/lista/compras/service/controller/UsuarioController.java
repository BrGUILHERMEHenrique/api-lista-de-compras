package com.compras.lista.compras.service.controller;

import com.compras.lista.compras.application.dto.UsuarioLogin;
import com.compras.lista.compras.domain.Usuario;
import com.compras.lista.compras.infrastructure.exceptions.NotFoundException;
import com.compras.lista.compras.infrastructure.exceptions.UsuarioNotFoundException;
import com.compras.lista.compras.service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public ResponseEntity login(@RequestBody UsuarioLogin login) throws Exception {
        String token = usuarioService.login(login);
        Usuario usuario = usuarioService.findByEmail(login.getEmail());
        HttpHeaders headers = new HttpHeaders();
        if(!Objects.equals(token, "")) {
            headers.add("token", token);
            return ResponseEntity.ok().headers(headers).body(usuario);
        } else {
            return ResponseEntity.badRequest().body("N]ao foi possivel efetuar o login");
        }
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario, @PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(usuarioService.atualizar(usuario, id));
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.delete(id));
    }
}
