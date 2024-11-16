package com.challenge.fretemais.controllers;

import com.challenge.fretemais.entities.packages.PackageFreight;
import com.challenge.fretemais.entities.packages.PackageRepository;
import com.challenge.fretemais.entities.packages.PackageRequestDTO;
import com.challenge.fretemais.entities.packages.PackageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("package")
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
}
