package com.project.hotel.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
/*
* Account_number: INTEGER
Booking_Reservation ID: INT
Amount to be paid
Amount of the prepayment
Amount for additional services
*
* */

@Entity
@Table(name = "Accounts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
/*
@HashCode
@EqualsAndHashCode

 */


public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_number")
    private int accountNumber;

    @Column(name = "Amount to be paid")
    private int amountToBePaid;


    @Column(name = "Amount of the prepayment")
    private int amountOfPrepayment;
    @Column(name = "Amount for additionalServices")
    private int amountForAdditionalServices;
    @OneToMany(mappedBy = "accounts")
    private List<PaymentForAdditionalServices> paymentForAdditionalServices;
    @OneToOne
    @JoinColumn(name="Booking_Reservation ID",referencedColumnName ="Reservation ID" )
    private Booking booking;

    /*
    @Override
    public String toString() {
        return "Accounts{" +
                "accountNumber=" + accountNumber +
                ", amountToBePaid=" + amountToBePaid +
                ", amountOfPrepayment=" + amountOfPrepayment +
                ", amountForAdditionalServices=" + amountForAdditionalServices +
                ", paymentForAdditionalServices=" + paymentForAdditionalServices +
                ", booking=" + booking +
                '}';
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAmountToBePaid() {
        return amountToBePaid;
    }

    public void setAmountToBePaid(int amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }

    public int getAmountOfPrepayment() {
        return amountOfPrepayment;
    }

    public void setAmountOfPrepayment(int amountOfPrepayment) {
        this.amountOfPrepayment = amountOfPrepayment;
    }

    public int getAmountForAdditionalServices() {
        return amountForAdditionalServices;
    }

    public void setAmountForAdditionalServices(int amountForAdditionalServices) {
        this.amountForAdditionalServices = amountForAdditionalServices;
    }

    public List<PaymentForAdditionalServices> getPaymentForAdditionalServices() {
        return paymentForAdditionalServices;
    }

    public void setPaymentForAdditionalServices(List<PaymentForAdditionalServices> paymentForAdditionalServices) {
        this.paymentForAdditionalServices = paymentForAdditionalServices;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

     */
}
