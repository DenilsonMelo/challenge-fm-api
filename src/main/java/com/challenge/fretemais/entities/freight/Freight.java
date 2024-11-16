package com.challenge.fretemais.entities.freight;

import com.challenge.fretemais.entities.carrier.Carrier;
import com.challenge.fretemais.entities.driver.Driver;
import com.challenge.fretemais.entities.packages.PackageFreight;
import com.challenge.fretemais.entities.payment.Payment;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "freight")
@Entity(name = "freight")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Freight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datefreight")
    private String dateFreight;

    private String status;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private PackageFreight packages;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Freight(FreightRequestDTO data, Driver driver, Carrier carrier, PackageFreight packages, Payment payment){
        this.status = data.status();
        this.dateFreight = data.dateFreight();
        this.driver = driver;
        this.carrier = carrier;
        this.packages = packages;
        this.payment = payment;
    }
}
