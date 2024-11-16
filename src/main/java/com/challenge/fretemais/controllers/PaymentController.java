package com.challenge.fretemais.controllers;


import com.challenge.fretemais.entities.payment.Payment;
import com.challenge.fretemais.entities.payment.PaymentRepository;
import com.challenge.fretemais.entities.payment.PaymentRequestDTO;
import com.challenge.fretemais.entities.payment.PaymentResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
@Tag(name = "Payment", description = "Gerenciamento de Pagamentos")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @CrossOrigin
    @PostMapping
    public void savePayment(@RequestBody PaymentRequestDTO data){
        Payment carPayment = new Payment(data);
        repository.save(carPayment);
        return;
    }

    @CrossOrigin
    @GetMapping
    public List<PaymentResponseDTO> findAll(){
        List<PaymentResponseDTO> paymentList = repository.findAll().stream().map(PaymentResponseDTO::new).toList();

        return paymentList;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Payment findPaymentById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
    }
}
