package com.challenge.fretemais.controllers;

import com.challenge.fretemais.entities.car.Car;
import com.challenge.fretemais.entities.car.CarRepository;
import com.challenge.fretemais.entities.car.CarRequestDTO;
import com.challenge.fretemais.entities.car.CarResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
@Tag(name = "Car", description = "Gerenciamento de Veículos")
public class CarController {
    @Autowired
    private CarRepository repository;

    @CrossOrigin
    @PostMapping
    public void saveDriver(@RequestBody CarRequestDTO data){
        Car carData = new Car(data);
        repository.save(carData);
        return;
    }

    @CrossOrigin
    @GetMapping
    public List<CarResponseDTO> findAll(){
        List<CarResponseDTO> carList = repository.findAll().stream().map(CarResponseDTO::new).toList();

        return carList;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Car findCarById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id " + id));
    }
}
