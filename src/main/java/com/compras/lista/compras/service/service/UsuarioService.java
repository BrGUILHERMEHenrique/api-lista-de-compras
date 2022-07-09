package com.compras.lista.compras.service.service;

import com.compras.lista.compras.application.dto.UsuarioLogin;
import com.compras.lista.compras.domain.Usuario;
import com.compras.lista.compras.infrastructure.exceptions.UsuarioNotFoundException;
import com.compras.lista.compras.infrastructure.repositories.UsuarioRepository;
import com.compras.lista.compras.service.configJWT.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AuthenticationManager manager;

    private String generateToken(Usuario usuario) throws Exception {
        try {
            manager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha())
            );
        } catch(Exception e){
            throw new Exception("Usuario nao encontrado");
        }

        return jwtUtils.generateToken(usuario.getEmail());
    }

    public String login(UsuarioLogin login) throws Exception {
        Usuario usuario = usuarioRepository.findByEmail(login.getEmail());
        return generateToken(usuario);
    }
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public String createUsuario(Usuario user) throws Exception {
        return generateToken(usuarioRepository.save(user));
    }

    public Usuario findById(Long id) throws UsuarioNotFoundException {
        Optional<Usuario> u = usuarioRepository.findById(id);
        if(u.isEmpty()){
            throw new UsuarioNotFoundException("Usuario nao encontrado na base de dados");
        }
        return u.get();
    }

    public boolean delete(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Usuario atualizar(Usuario usuario) throws UsuarioNotFoundException {
        Usuario usuarioAtualizado = findById(usuario.getId());

        if (usuario.getEmail() != null) usuarioAtualizado.setEmail(usuario.getEmail());
        if (usuario.getNome() != null) usuarioAtualizado.setNome(usuario.getNome());
        if (usuario.getSenha() != null) usuarioAtualizado.setSenha(usuario.getSenha());
        if (usuario.getFamilia() != null) usuarioAtualizado.setFamilia(usuario.getFamilia());

        //TODO implementar validacao com equals
        return usuarioRepository.save(usuarioAtualizado);

    }
}
