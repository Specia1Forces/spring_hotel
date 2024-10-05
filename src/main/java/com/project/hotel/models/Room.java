package com.project.hotel.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Room")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Room code")
    private int roomCode;
    //@Column(name = "Room numbers")
    //private int roomNumbers;
    @Column(name = "Floor")
    private String floor;
    @Column(name = "occupied free")
    private String occupiedFree;
    @ManyToOne
    @JoinColumn(name="Room category_Class room ID",referencedColumnName ="Class room ID" )
    private RoomCategory roomCategory;
    @OneToMany(mappedBy = "room")
    private List<RelBetweenRoomsBooking> relBetweenRoomsBooking;

    @Override
    public String toString() {
        return "Room{" +
                "roomCode=" + roomCode +
                ", floor='" + floor + '\'' +
                ", occupiedFree='" + occupiedFree + '\'' +
                ", roomCategory=" + roomCategory +
                ", relBetweenRoomsBooking=" + relBetweenRoomsBooking +
                '}';
    }
}
