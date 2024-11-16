package com.challenge.fretemais.entities.freight;
public record FreightRequestDTO(String dateFreight, String status, Long driver, Long packages, Long payment, Long carrier) {
}
