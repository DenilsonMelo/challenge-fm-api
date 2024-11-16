package com.challenge.fretemais.entities.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    record CarRequestDTO(String model, String type) {
    }
}
