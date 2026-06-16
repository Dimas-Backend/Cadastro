package com.example.cadastro.repositorys;

import com.example.cadastro.entitys.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

}
