package com.project.hotel.models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Client of hotel")
/*
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
*/
public class ClientOfHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Client ID")
    private int  clientId;//подумать
    @Column(name = "Name")
    private String name;
    @Column(name = "Middle name")
    private String middleName;
    @Column(name = "Last name")
    private String lastName;

    @Column(name = "Gender")
    private String gender;
    @Column(name = "Birthdate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy") // дд/мм/гггг
    private Date birthdate; //DATA
    @Column(name = "Address")
    private String address;
    @Column(name = "Phone")
    private String phone;
    @OneToMany(mappedBy = "clientOfHotel")
    private List<Contracts> contracts;
    @OneToMany(mappedBy = "clientOfHotel1")
    private List<Booking> booking;
    @OneToOne(mappedBy = "clientOfHotel3")
    private DocumentationPersonality documentationPersonality;

    @Override
    public String toString() {
        return "" +
                 clientId
                ;
    }

}
