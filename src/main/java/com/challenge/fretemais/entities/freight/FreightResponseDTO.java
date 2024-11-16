package com.challenge.fretemais.entities.freight;

import com.challenge.fretemais.entities.carrier.Carrier;
import com.challenge.fretemais.entities.driver.Driver;
import com.challenge.fretemais.entities.packages.PackageFreight;
import com.challenge.fretemais.entities.payment.Payment;

public record FreightResponseDTO(Long id, String dateFreight, String status, Driver driver, PackageFreight packages, Payment payment, Carrier carrier) {
    public FreightResponseDTO(Freight freight){
        this(freight.getId(), freight.getDateFreight(), freight.getStatus(), freight.getDriver(), freight.getPackages(), freight.getPayment(), freight.getCarrier());
    }
}
