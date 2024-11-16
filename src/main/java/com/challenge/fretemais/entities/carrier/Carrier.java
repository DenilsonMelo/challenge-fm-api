package com.challenge.fretemais.entities.carrier;

import com.challenge.fretemais.entities.freight.Freight;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "carrier")
@Entity(name = "carrier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "carrier", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Freight> freights = new ArrayList<>();

    public Carrier(CarrierRequestDTO data){
        this.name = data.name();
    }
}
