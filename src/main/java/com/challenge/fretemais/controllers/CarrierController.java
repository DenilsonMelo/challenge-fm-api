package com.challenge.fretemais.controllers;

import com.challenge.fretemais.entities.carrier.Carrier;
import com.challenge.fretemais.entities.carrier.CarrierRepository;
import com.challenge.fretemais.entities.carrier.CarrierRequestDTO;
import com.challenge.fretemais.entities.carrier.CarrierResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carrier")
@Tag(name = "Carrier", description = "Gerenciamento de Transportadoras")
public class CarrierController {
    @Autowired
    private CarrierRepository repository;

    @CrossOrigin
    @PostMapping
    public void saveCarrier(@RequestBody CarrierRequestDTO data){
        Carrier carrierData = new Carrier(data);
        repository.save(carrierData);
        return;
    }

    @CrossOrigin
    @GetMapping
    public List<CarrierResponseDTO> findAll(){
        List<CarrierResponseDTO> carrierList = repository.findAll().stream().map(CarrierResponseDTO::new).toList();

        return carrierList;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Carrier findCarrierById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrier not found with id " + id));
    }
}
