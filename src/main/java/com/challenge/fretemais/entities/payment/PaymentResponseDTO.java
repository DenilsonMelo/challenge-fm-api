package com.challenge.fretemais.entities.payment;


public record PaymentResponseDTO(Long id, String type, float amount) {
    public PaymentResponseDTO(Payment payment){
        this(payment.getId(), payment.getType(), payment.getAmount());
    }
}
