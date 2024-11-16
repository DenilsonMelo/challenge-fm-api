package com.challenge.fretemais.entities.driver;

public record DriverResponseDTO(Long id, String name) {
    public DriverResponseDTO(Driver driver){
        this(driver.getId(), driver.getName());
    }
}
