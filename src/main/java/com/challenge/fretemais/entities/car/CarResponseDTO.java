package com.challenge.fretemais.entities.car;

import com.challenge.fretemais.entities.driver.Driver;

public record CarResponseDTO(Long id, String model, String type) {
    public CarResponseDTO(Car car){
        this(car.getId(), car.getModel(), car.getType());
    }
}
