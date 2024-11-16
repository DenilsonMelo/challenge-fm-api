package com.challenge.fretemais.controllers;

import com.challenge.fretemais.entities.driver.Driver;
import com.challenge.fretemais.entities.driver.DriverRequestDTO;
import com.challenge.fretemais.entities.driver.DriverResponseDTO;
import com.challenge.fretemais.entities.packages.PackageFreight;
import com.challenge.fretemais.entities.packages.PackageRepository;
import com.challenge.fretemais.entities.packages.PackageRequestDTO;
import com.challenge.fretemais.entities.packages.PackageResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("package")
@Tag(name = "Package", description = "Gerenciamento de Cargas")
public class PackageController {
    @Autowired
    private PackageRepository repository;

    @CrossOrigin
    @PostMapping
    public void savePackage(@RequestBody PackageRequestDTO data){
        PackageFreight packageData = new PackageFreight(data);
        repository.save(packageData);
        return;
    }

    @CrossOrigin
    @GetMapping
    public List<PackageResponseDTO> findAll(){
        List<PackageResponseDTO> packageList = repository.findAll().stream().map(PackageResponseDTO::new).toList();

        return packageList;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public PackageFreight findPackageFreightById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PackageFreight not found with id " + id));
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<PackageResponseDTO> update(@PathVariable Long id, @RequestBody PackageRequestDTO data) {
        Optional<PackageFreight> optionalPackage = repository.findById(id);

        if (optionalPackage.isPresent()) {
            PackageFreight packages = optionalPackage.get();

            packages.setType(data.type());

            repository.save(packages);

            return ResponseEntity.ok(new PackageResponseDTO(packages));
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
