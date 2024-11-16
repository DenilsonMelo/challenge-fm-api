package com.challenge.fretemais.controllers;

import com.challenge.fretemais.entities.driver.Driver;
import com.challenge.fretemais.entities.driver.DriverRepository;
import com.challenge.fretemais.entities.driver.DriverResponseDTO;
import com.challenge.fretemais.entities.driver.DriverRequestDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("driver")
@Tag(name = "Driver", description = "Gerenciamento de Motoristas")
public class DriverController {
    @Autowired
    private DriverRepository repository;

    @CrossOrigin
    @PostMapping
    public void saveDriver(@RequestBody DriverRequestDTO data){
        Driver driverData = new Driver(data);
        repository.save(driverData);
        return;
    }

    @CrossOrigin
    @GetMapping
    public DriverResponseDTO[] findAll(){
        List<DriverResponseDTO> driverList = repository.findAll().stream().map(DriverResponseDTO::new).toList();

        return driverList.toArray(new DriverResponseDTO[0]);
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Driver findDriverById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id " + id));
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<DriverResponseDTO> update(@PathVariable Long id, @RequestBody DriverRequestDTO data) {
        Optional<Driver> optionalDriver = repository.findById(id);

        if (optionalDriver.isPresent()) {
            Driver driver = optionalDriver.get();

            driver.setName(data.name());

            repository.save(driver);

            return ResponseEntity.ok(new DriverResponseDTO(driver));
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
