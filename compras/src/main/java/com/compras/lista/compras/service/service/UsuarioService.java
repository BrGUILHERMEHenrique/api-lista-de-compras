package com.compras.lista.compras.service.service;

import com.compras.lista.compras.domain.Usuario;
import com.compras.lista.compras.infrastructure.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public void createUsuario(Usuario user){
        usuarioRepository.save(user);
    }
}
