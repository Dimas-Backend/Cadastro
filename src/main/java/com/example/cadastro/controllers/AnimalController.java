package com.example.cadastro.controllers;

import com.example.cadastro.DTOs.AnimalDTOs.AnimalIdDTO;
import com.example.cadastro.DTOs.AnimalDTOs.AnimalRequestDTO;
import com.example.cadastro.DTOs.AnimalDTOs.AnimalResponseDTO;
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
    public String adicionarPai(@PathVariable AnimalIdDTO bezerroDto, @PathVariable AnimalIdDTO paiDTO){
        animalService.adicionarPai(bezerroDto.Id(),paiDTO.Id());
        return "Pai "+paiDTO.Id() + "adicionado com sucesso ao bezerro com o id: "+ bezerroDto.Id();
}
    @PutMapping("/{id}/mae/{idMae}")
    public String adicionarMae(@PathVariable AnimalIdDTO bezerroDto, @PathVariable AnimalIdDTO maeDTO){
         animalService.adicionarMae(bezerroDto.Id(), maeDTO.Id());
        return "Mãe "+maeDTO.Id() + "adicionada com sucesso ao bezerro com o id: "+ bezerroDto.Id();

}
   @GetMapping("/{id}")
   public ResponseEntity<AnimalResponseDTO> getAnimal(@PathVariable Long id){
        AnimalResponseDTO response = animalService.getAnimal(id);
        return ResponseEntity.ok(response);
    }

}
