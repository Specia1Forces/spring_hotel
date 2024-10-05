package com.project.hotel.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*
* Service ID: INTEGER
name: TINYTEXT
Service price: INTEGER
*
*
* */


@Entity
@Table(name = "All services")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class AllServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Service ID")

    private int serviceId;

    @Override
    public String toString() {
        return "AllServices{" +
                "serviceId=" + serviceId +
                ", name='" + name + '\'' +
                ", servicePrice=" + servicePrice +
                ", paymentForAdditionalServices=" + paymentForAdditionalServices +
                '}';
    }

    @Column(name = "name")
    private String name;
    @Column(name = "Service price")
    private int servicePrice;
    @OneToMany(mappedBy = "allServices")
    private List<PaymentForAdditionalServices> paymentForAdditionalServices;


}
