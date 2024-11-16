package com.challenge.fretemais.controllers;

import com.challenge.fretemais.entities.carrier.Carrier;
import com.challenge.fretemais.entities.carrier.CarrierRepository;
import com.challenge.fretemais.entities.driver.Driver;
import com.challenge.fretemais.entities.driver.DriverRepository;
import com.challenge.fretemais.entities.freight.Freight;
import com.challenge.fretemais.entities.freight.FreightRepository;
import com.challenge.fretemais.entities.freight.FreightRequestDTO;
import com.challenge.fretemais.entities.freight.FreightResponseDTO;
import com.challenge.fretemais.entities.packages.PackageFreight;
import com.challenge.fretemais.entities.packages.PackageRepository;
import com.challenge.fretemais.entities.payment.Payment;
import com.challenge.fretemais.entities.payment.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("freight")
public class FreightController {
    @Autowired
    private FreightRepository repository;

    @Autowired
    private CarrierRepository carrierRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PackageRepository packageFreightRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @CrossOrigin
    @PostMapping
    public Freight saveFreight(@RequestBody FreightRequestDTO data){

        Carrier carrier = carrierRepository.findById(data.carrier()).orElseThrow(() -> new RuntimeException("Carrier not found"));
        Driver driver = driverRepository.findById(data.driver()).orElseThrow(() -> new RuntimeException("Driver not found"));
        PackageFreight packageFreight = packageFreightRepository.findById(data.packages()).orElseThrow(() -> new RuntimeException("Package not found"));
        Payment payment = paymentRepository.findById(data.payment()).orElseThrow(() -> new RuntimeException("Payment not found"));

        Freight freightData = new Freight(data, driver, carrier, packageFreight, payment);
        repository.save(freightData);
        return freightData;
    }

    @CrossOrigin
    @GetMapping
    public List<FreightResponseDTO> findAll(){
        List<FreightResponseDTO> freightList = repository.findAll().stream().map(FreightResponseDTO::new).toList();

        return freightList;
    }
}