package com.example.cadastro.controllers;

import com.example.cadastro.DTOs.AnimalDTOs.AnimalRequestDTO;
import com.example.cadastro.entitys.AnimalEntity;
import com.example.cadastro.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private final AnimalService animalService;
    public AnimalController (AnimalService animalService){
        this.animalService = animalService;
    }
    @PostMapping
    public String adicionarAnimal(@RequestBody AnimalRequestDTO dto){
        animalService.adicionarAnimal(dto);
        return "Animal criado com sucesso!";
    }
    @PutMapping("/{id}/pai/{idPai}")
    public ResponseEntity<AnimalEntity> adicionarPai(@PathVariable Long id, @PathVariable Long idPai){
        AnimalEntity salvo = animalService.adicionarPai(id,idPai);
        return ResponseEntity.ok(salvo);
}
    @PutMapping("/{id}/mae/{idMae}")
    public ResponseEntity<AnimalEntity> adicionarMae(@PathVariable Long id, @PathVariable Long idMae){
        AnimalEntity salvo = animalService.adicionarMae(id,idMae);
        return ResponseEntity.ok(salvo);
}
}
