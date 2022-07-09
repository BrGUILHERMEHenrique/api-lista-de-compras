package com.compras.lista.compras.service.service;

import com.compras.lista.compras.domain.Familia;
import com.compras.lista.compras.domain.Item;
import com.compras.lista.compras.domain.Lista;
import com.compras.lista.compras.infrastructure.exceptions.NotFoundException;
import com.compras.lista.compras.infrastructure.repositories.FamiliaRepository;
import com.compras.lista.compras.infrastructure.repositories.ItemRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ListaService listaService;

    public Item findById(Long id) throws NotFoundException {
        Optional<Item> i = itemRepository.findById(id);

        if(i.isEmpty()){
            throw new NotFoundException(Item.class.getName());
        }else{
            return i.get();
        }
    }

    public List<Item> findByLista(Long idLista) throws NotFoundException {
        Lista lista = listaService.findById(idLista);
        List<Item> items = itemRepository.findByLista(lista);

        if(items.isEmpty()){
            throw new NotFoundException(Item.class.getName());
        } else {
            return items;
        }
    }

    public void createItem(Item item){
        itemRepository.save(item);
    }

    public boolean delete(Long id){
        try{
            itemRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Item atualizar(Item item) throws NotFoundException {
        Item itemAtualizado = findById(item.getId());

        if (item.getNome() != null) itemAtualizado.setNome(item.getNome());
        if (item.getPreco() != null) itemAtualizado.setPreco(item.getPreco());
        if (item.getQtd() != 0) itemAtualizado.setQtd(item.getQtd());

        // TODO Implementar proteçao usando o equals
        return itemRepository.save(itemAtualizado);
    }
}
