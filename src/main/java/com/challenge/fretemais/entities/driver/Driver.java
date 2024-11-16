package com.challenge.fretemais.entities.driver;

import com.challenge.fretemais.entities.freight.Freight;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "driver")
@Entity(name = "driver")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Freight> freights = new ArrayList<>();

    public Driver(DriverRequestDTO data){
        this.name = data.name();
    }
}
