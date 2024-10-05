package com.project.hotel.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
/*Booking  Новая версия
Reservation ID
Client of hotel_Client ID
Settlement date: DATE
Eviction date: DATE
Total amount of the payment: INTEGER
Prepayment status
Booking status
Residence status
*
* */

@Entity
@Table(name = "Booking")

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reservation ID")
    private int reservationId;
    @Column(name = "Settlement date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy") // дд/мм/гггг
    private Date settlementDate;
    @Column(name = "Eviction date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy") // дд/мм/гггг
    private Date evictionDate;
    @Column(name = "Total amount of the payment")
    private int totalAmountOfPayment;
    @Column(name = "Prepayment status")
    private String prepaymentStatus;
    @Column(name = "Booking status")
    private String bookingStatus;
    @Column(name = "Residence status")
    private String residenceStatus;

    @ManyToOne
    @JoinColumn(name="Client of hotel_Client ID",referencedColumnName ="Client ID" )
    private ClientOfHotel clientOfHotel1;
    @OneToOne(mappedBy = "booking")
    private Accounts accounts;
    @OneToMany(mappedBy = "booking1")
    private List<RelBetweenRoomsBooking> relBetweenRoomsBooking;



}
