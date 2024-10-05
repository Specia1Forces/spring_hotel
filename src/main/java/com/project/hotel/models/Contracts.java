package com.project.hotel.models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*
* Contracts НОВАЯ ВЕРСИЯ
contract number: INTEGER
Client of hotel_Client ID: INTEGER (FK)
Term of stay: INTEGER
date conclusion agreement: DATETIME
* */

@Entity
@Table(name = "Contracts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract number")
    private int contractNumber;
    //@Column(name = "Room numbers")
    //private int roomNumbers;
    @Column(name = "Term of stay")
    private int termOfStay;

    @Override
    public String toString() {
        return "Contracts{" +
                "contractNumber=" + contractNumber +
                ", termOfStay=" + termOfStay +
                ", dateConclusionAgreement=" + dateConclusionAgreement +
                '}';
    }

    @Column(name = "date conclusion agreement")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy") // дд/мм/гггг
    private Date dateConclusionAgreement;
    @ManyToOne
    @JoinColumn(name="Client of hotel_Client ID",referencedColumnName ="Client ID" )
    private ClientOfHotel clientOfHotel;
}
