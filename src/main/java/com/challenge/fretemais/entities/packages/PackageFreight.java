package com.challenge.fretemais.entities.packages;

import com.challenge.fretemais.entities.freight.Freight;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "package")
@Entity(name = "package")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class PackageFreight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @OneToMany(mappedBy = "packages", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Freight> freights = new ArrayList<>();

    public PackageFreight(PackageRequestDTO data){
        this.type = data.type();
    }
}