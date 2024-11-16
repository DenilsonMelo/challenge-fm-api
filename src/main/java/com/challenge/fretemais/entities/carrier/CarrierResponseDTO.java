package com.challenge.fretemais.entities.carrier;

public record CarrierResponseDTO(Long id, String name) {
    public CarrierResponseDTO(Carrier carrier){
        this(carrier.getId(), carrier.getName());
    }
}
