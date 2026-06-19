package com.example.cadastro.DTOs.AnimalDTOs;

public record AnimalResponseDTO(
        Long id,
        String raca,
        char sexo,
        Long paiId,
        Long maeId
) {}
