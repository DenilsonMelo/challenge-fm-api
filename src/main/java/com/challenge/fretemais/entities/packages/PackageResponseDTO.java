package com.challenge.fretemais.entities.packages;

public record PackageResponseDTO(Long id, String type) {
    public PackageResponseDTO(PackageFreight packages){
        this(packages.getId(), packages.getType());
    }
}
