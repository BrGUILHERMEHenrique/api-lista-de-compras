package com.compras.lista.compras.service.service;

import com.compras.lista.compras.domain.Familia;
import com.compras.lista.compras.infrastructure.exceptions.NotFoundException;
import com.compras.lista.compras.infrastructure.repositories.FamiliaRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class FamiliaService {

    @Autowired
    FamiliaRepository familiaRepository;

    public Familia findById(Long id) throws NotFoundException {
        Optional<Familia> f = familiaRepository.findById(id);

        if(f.isEmpty()){
            throw new NotFoundException(Familia.class.getName());
        } else {
            return f.get();
        }
    }

    public void createFamilia(Familia familia){
        familiaRepository.save(familia);
    }

    public boolean delete(Long id) {
        try{
            familiaRepository.deleteById(id);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public Familia autalizar(Familia familia) throws NotFoundException {
        Familia familiaAtualizada = findById(familia.getId());

        if (familia.getLista() != null) familiaAtualizada.setLista(familia.getLista());
        if (familia.getNome() != null) familiaAtualizada.setNome(familia.getNome());

        //TODO implementar validaçao por equals

        return familiaRepository.save(familiaAtualizada);
    }
}
