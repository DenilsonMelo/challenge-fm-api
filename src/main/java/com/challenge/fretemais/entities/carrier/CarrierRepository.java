package com.challenge.fretemais.entities.carrier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {
    record CarrierRequestDTO(String name) {
    }
}
