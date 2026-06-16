package com.example.cadastro.services;

import com.example.cadastro.entitys.AnimalEntity;
import com.example.cadastro.repositorys.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;
    public AnimalEntity adicionarAnimal(AnimalEntity animal){
        return animalRepository.save(animal);}

    public AnimalEntity adicionarPai(Long id, Long Idpai){
        AnimalEntity animal  = animalRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Animal não Encontrado"));
        AnimalEntity pai = animalRepository.findById(Idpai)
                        .orElseThrow(()-> new  RuntimeException("Animal não encontrado"));
        animal.setTouro(pai);
        return animalRepository.save(animal);
    }
    public AnimalEntity adicionarMae(Long id, Long Idmae){
        AnimalEntity animal  = animalRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Animal não Encontrado"));
        AnimalEntity mae = animalRepository.findById(Idmae)
                .orElseThrow(()-> new  RuntimeException("Animal não encontrado"));
        animal.setVaca(mae);
        return animalRepository.save(animal);
}
}
