package com.example.cadastro.DTOs.AnimalDTOs;

public record AnimalRequestDTO(
        String raca,
        Long paiId,
        Long maeId
) {}
