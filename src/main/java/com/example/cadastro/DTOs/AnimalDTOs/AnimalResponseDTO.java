package com.example.cadastro.DTOs.AnimalDTOs;

public record AnimalResponseDTO(
        Long id,
        String raca,
        Long paiId,
        Long maeId
) {}
