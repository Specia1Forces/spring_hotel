package com.project.hotel.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
*
* Payment for add services ID
All services_Service ID
Accounts_Account_number
Date:DATA
count services:int
The total amount of payment:int
Payment method :tinytext
Payment status :tinytext
* */
@Entity
@Table(name = "Payment for additional services")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PaymentForAdditionalServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Payment for add services ID")
    private int paymentForAddServicesId;


    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy") // дд/мм/гггг
    private Date date;
    @Column(name = "count services")
    private int countServices;
    @Column(name = "The total amount of payment")
    private int totalAmountOfPayment;
    @Column(name = "Payment method")
    private String paymentMethod;
    @Column(name = "Payment status")
    private String paymentStatus;

    @Override
    public String toString() {
        return "PaymentForAdditionalServices{" +
                "paymentForAddServicesId=" + paymentForAddServicesId +
                ", date=" + date +
                ", countServices=" + countServices +
                ", totalAmountOfPayment=" + totalAmountOfPayment +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", allServices=" + allServices +
                ", accounts=" + accounts +
                '}';
    }

    @ManyToOne
    @JoinColumn(name="All services_Service ID",referencedColumnName ="Service ID" )
    private AllServices allServices;
    @ManyToOne
    @JoinColumn(name="Accounts_Account_number",referencedColumnName ="Account_number" )
    private Accounts accounts;


}
