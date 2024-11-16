package com.challenge.fretemais.entities.car;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "car")
@Entity(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String type;

    public Car(CarRequestDTO data){
        this.model = data.model();
        this.type = data.type();
    }
}
