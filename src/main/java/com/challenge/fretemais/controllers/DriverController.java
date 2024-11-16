package com.challenge.fretemais.controllers;

import com.challenge.fretemais.entities.driver.Driver;
import com.challenge.fretemais.entities.driver.DriverRepository;
import com.challenge.fretemais.entities.driver.DriverResponseDTO;
import com.challenge.fretemais.entities.driver.DriverRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("driver")
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
}
