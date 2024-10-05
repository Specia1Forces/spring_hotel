package com.project.hotel.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Technical Maintenance Personnel")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TechnicalMaintenancePersonnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Collaborator Maintenance ID")
    private int  collaboratorMaintenanceID;//подумать
    @Column(name = "Name")
    private String name;
    @Column(name = "Middle name")
    private String middleName;
    @Column(name = "Last name")
    private String lastName;
    @OneToMany(mappedBy = "technicalMaintenancePersonnel")
    private List<MaintenanceLog> maintenanceLog;

    @Override
    public String toString() {
        return "TechnicalMaintenancePersonnel{" +
                "collaboratorMaintenanceID=" + collaboratorMaintenanceID +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", maintenanceLog=" + maintenanceLog +
                '}';
    }
}
