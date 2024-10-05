package com.project.hotel.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Maintenance Log")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class MaintenanceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Maintenance Log ID")
    private int maintenanceLogId;
    @Column(name = "Problem in the dimension")
    private String probleminDimension;

    @Column(name = "Fixed or uncorrected")
    private String fixedOrUncorrected;
    @ManyToOne
    @JoinColumn(name="Technical Maintenance Personne_Collaborator Maintenance ID",referencedColumnName ="Collaborator Maintenance ID" )
    private TechnicalMaintenancePersonnel technicalMaintenancePersonnel;

    @Override
    public String toString() {
        return "MaintenanceLog{" +
                "maintenanceLogId=" + maintenanceLogId +
                ", probleminDimension='" + probleminDimension + '\'' +
                ", fixedOrUncorrected='" + fixedOrUncorrected + '\'' +
                ", technicalMaintenancePersonnel=" + technicalMaintenancePersonnel +
                ", relBetweenRoomsBooking2=" + relBetweenRoomsBooking2 +
                '}';
    }

    @ManyToOne
    @JoinColumn(name="Rel between rooms booking_Relationship ID2",referencedColumnName ="Relationship ID" )
    private RelBetweenRoomsBooking relBetweenRoomsBooking2;
}
