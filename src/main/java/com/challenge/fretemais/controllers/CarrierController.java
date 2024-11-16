package com.challenge.fretemais.controllers;

import com.challenge.fretemais.entities.carrier.Carrier;
import com.challenge.fretemais.entities.carrier.CarrierRepository;
import com.challenge.fretemais.entities.carrier.CarrierRequestDTO;
import com.challenge.fretemais.entities.carrier.CarrierResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<CarrierResponseDTO> update(@PathVariable Long id, @RequestBody CarrierRequestDTO data) {
        Optional<Carrier> optionalCarrier = repository.findById(id);

        if (optionalCarrier.isPresent()) {
            Carrier carrier = optionalCarrier.get();

            carrier.setName(data.name());

            repository.save(carrier);

            return ResponseEntity.ok(new CarrierResponseDTO(carrier));
        }

        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
