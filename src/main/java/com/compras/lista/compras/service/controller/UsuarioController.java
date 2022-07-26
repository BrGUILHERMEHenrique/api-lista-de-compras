package com.compras.lista.compras.service.controller;

import com.compras.lista.compras.application.dto.UsuarioLogin;
import com.compras.lista.compras.domain.Usuario;
import com.compras.lista.compras.service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity login(@RequestBody UsuarioLogin login) throws Exception {
        String token = usuarioService.login(login);
        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.add("token", token);
            return ResponseEntity.ok().headers(headers).body("Login efetuado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("N]ao foi possivel efetuar o login");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.delete(id));
    }
}
