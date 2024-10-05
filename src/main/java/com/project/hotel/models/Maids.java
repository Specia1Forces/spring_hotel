package com.project.hotel.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
//дорабоать генератор

@Entity
@Table(name = "The Maids")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Maids {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAID_ID")
    private int maidId;//подумать
    @Column(name = "Name")
    private String name;
    @Column(name = "Middle name")
    private String middleName;
    @Column(name = "Last name")
    private String lastName;
    @OneToMany(mappedBy = "maids")
    private List<CleaningSchedule> cleaningSchedule;


    @Override
    public String toString() {
        return "Maids{" +
                "maidId=" + maidId +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cleaningSchedule=" + cleaningSchedule +
                '}';
    }
}
