package com.project.hotel.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*
* Relationship ID (unique communication identifier)
Booking_Reservation ID INT
Room_Room code INT
*
* */
@Entity
@Table(name = "Rel between rooms booking")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RelBetweenRoomsBooking {
    @Override
    public String toString() {
        return "RelBetweenRoomsBooking{" +
                "relationshipId=" + relationshipId +
                ", cleaningSchedule=" + cleaningSchedule +
                ", MaintenanceLog=" + MaintenanceLog +
                ", booking1=" + booking1 +
                ", room=" + room +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Relationship ID")
    private int relationshipId;
    @OneToMany(mappedBy = "relBetweenRoomsBooking")
    private List<CleaningSchedule> cleaningSchedule;
    @OneToMany(mappedBy = "relBetweenRoomsBooking2")
    private List<MaintenanceLog> MaintenanceLog;
    @ManyToOne
    @JoinColumn(name="Booking_Reservation ID",referencedColumnName ="Reservation ID" )
    private Booking booking1;
    @ManyToOne
    @JoinColumn(name="Room_Room code",referencedColumnName ="Room code" )
    private Room room;

}
