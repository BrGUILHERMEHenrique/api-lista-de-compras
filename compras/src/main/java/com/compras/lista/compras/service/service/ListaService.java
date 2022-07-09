package com.compras.lista.compras.service.service;

import com.compras.lista.compras.domain.Lista;
import com.compras.lista.compras.infrastructure.exceptions.NotFoundException;
import com.compras.lista.compras.infrastructure.repositories.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListaService {

    @Autowired
    ListaRepository listaRepository;

    public Lista findById(Long id) throws NotFoundException {
        Optional<Lista> l = listaRepository.findById(id);

        if(l.isEmpty()){
            throw new NotFoundException(Lista.class.getName());
        } else {
            return l.get();
        }
    }

    public void createLista(Lista lista){
        listaRepository.save(lista);
    }

    public boolean delete(Long id){
        try{
            listaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Lista atualizar(Lista lista) throws NotFoundException {
        Lista listaAtualizada = findById(lista.getId());

        if (lista.getValorTotal() != 0) listaAtualizada.setValorTotal(lista.getValorTotal());
        if (lista.getFinalizada() != null) listaAtualizada.setFinalizada(lista.getFinalizada());

        //TODO implementar validaçao por equals

        return listaRepository.save(listaAtualizada);
    }
}
