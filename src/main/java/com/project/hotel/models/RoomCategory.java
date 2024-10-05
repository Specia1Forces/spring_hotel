package com.project.hotel.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Room category")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RoomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Class room ID")
    private int classRoomId;
    @Column(name = "Room type")
    private String roomType;
    @Column(name = "Rent value")
    private int rentValue;
    @Column(name = "Number of places")
    private int numberOfPlaces;

    @Column(name = "Description")
    private String description;
    @OneToMany(mappedBy = "roomCategory")
    private List<Room> room;

    @Override
    public String toString() {
        return "RoomCategory{" +
                "classRoomId=" + classRoomId +
                ", roomType='" + roomType + '\'' +
                ", rentValue=" + rentValue +
                ", numberOfPlaces=" + numberOfPlaces +
                ", description='" + description + '\'' +
                ", room=" + room +
                '}';
    }
}
