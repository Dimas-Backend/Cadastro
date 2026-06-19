package com.example.cadastro.DTOs.AnimalDTOs;

public record AnimalRequestDTO(
        String raca,
        char sexo,
        Long paiId,
        Long maeId
) {}
