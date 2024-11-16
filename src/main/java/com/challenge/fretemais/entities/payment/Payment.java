package com.challenge.fretemais.entities.payment;

import com.challenge.fretemais.entities.freight.Freight;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "payment")
@Entity(name = "payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private Float amount;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Freight> freights = new ArrayList<>();
    public Payment(PaymentRequestDTO data){
        this.amount = data.amount();
        this.type = data.type();
    }
}
