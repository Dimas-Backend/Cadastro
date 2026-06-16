package com.example.cadastro.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String raca;
    private char sexo;
    @OneToOne
    @JoinColumn(name ="vacina_card_Id")
    private VacinaCardEntity vacinaCardEntity;
    @ManyToOne
    @JoinColumn(name= "pai_id")
    private AnimalEntity touro;
    @ManyToOne
    @JoinColumn(name= "vaca_id")
    private AnimalEntity vaca;

    public AnimalEntity(String raca, char sexo) {
        this.raca = raca;
        this.sexo = sexo;
    }


}
