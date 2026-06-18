package com.example.cadastro.services;

import com.example.cadastro.DTOs.AnimalDTOs.AnimalRequestDTO;
import com.example.cadastro.DTOs.AnimalDTOs.AnimalResponseDTO;
import com.example.cadastro.entitys.AnimalEntity;
import com.example.cadastro.repositorys.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;
    public void adicionarAnimal(AnimalRequestDTO requestDTO){
         AnimalEntity animal = new AnimalEntity();
         animal.setRaca(requestDTO.raca());
         animal.setSexo(requestDTO.sexo());
         if(requestDTO.paiId() != null){
             AnimalEntity pai = animalRepository.findById(requestDTO.paiId())
                     .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
             if(pai.getSexo() != 'M')  {throw new RuntimeException("O pai deve ser obrigatoriamente um macho!");}
             animal.setTouro(pai);
         }
         if(requestDTO.maeId() != null) {
             AnimalEntity mae = animalRepository.findById(requestDTO.maeId())
                     .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
             if(mae.getSexo() != 'F')  {throw new RuntimeException("A mãe deve ser obrigatoriamente uma fêmea!");}
             animal.setVaca(mae);
         }
          animalRepository.save(animal);


    }

    public void adicionarPai(Long id, Long Idpai){
        AnimalEntity animal  = animalRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Animal não Encontrado"));
        AnimalEntity pai = animalRepository.findById(Idpai)
                        .orElseThrow(()-> new  RuntimeException("Animal não encontrado"));
        if(pai.getSexo() != 'M'){
           throw new RuntimeException("O Touro selecionado não é um macho!");
        }
        animal.setTouro(pai);
         animalRepository.save(animal);
    }
    public void adicionarMae(Long id, Long Idmae){
        AnimalEntity animal  = animalRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Animal não Encontrado"));
        AnimalEntity mae = animalRepository.findById(Idmae)
                .orElseThrow(()-> new  RuntimeException("Animal não encontrado"));
        if(mae.getSexo() != 'F' )
            throw new RuntimeException("O Touro selecionado não é um macho!");
        animal.setVaca(mae);
         animalRepository.save(animal);
}
    public AnimalResponseDTO getAnimal(Long id){
        AnimalEntity animal = animalRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Animal não encontrado!"));

        AnimalResponseDTO responseDTO = new AnimalResponseDTO(
                animal.getId(),
                animal.getRaca(),
                animal.getSexo(),
                (animal.getTouro() != null) ? animal.getTouro().getId() : null,
                (animal.getVaca() != null) ? animal.getVaca().getId() : null);
        return  responseDTO;

    }
}
