package com.project.hotel.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Cleaning schedule")
/*
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
*/
public class CleaningSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cleaning schedule ID")
    private int CleaningScheduleId;
    @Column(name = "Cleaning date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy") // дд/мм/гггг
    private Date cleaningDate;//

    @Column(name = "Cleaning status")
    private String cleaningStatus;
    @ManyToOne
    @JoinColumn(name="The maids_MAID_ID",referencedColumnName ="MAID_ID" )
    private Maids maids;

    public int getCleaningScheduleId() {
        return CleaningScheduleId;
    }

    public void setCleaningScheduleId(int cleaningScheduleId) {
        CleaningScheduleId = cleaningScheduleId;
    }

    public Date getCleaningDate() {
        return cleaningDate;
    }

    public void setCleaningDate(Date cleaningDate) {
        this.cleaningDate = cleaningDate;
    }

    public String getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public Maids getMaids() {
        return maids;
    }

    public void setMaids(Maids maids) {
        this.maids = maids;
    }

    public RelBetweenRoomsBooking getRelBetweenRoomsBooking() {
        return relBetweenRoomsBooking;
    }

    public void setRelBetweenRoomsBooking(RelBetweenRoomsBooking relBetweenRoomsBooking) {
        this.relBetweenRoomsBooking = relBetweenRoomsBooking;
    }

    @ManyToOne
    @JoinColumn(name="Rel between rooms booking_Relationship ID",referencedColumnName ="Relationship ID" )
    private RelBetweenRoomsBooking relBetweenRoomsBooking;

    @Override
    public String toString() {
        return "CleaningSchedule{" +
                "CleaningScheduleId=" + CleaningScheduleId +
                ", cleaningDate=" + cleaningDate +
                ", cleaningStatus='" + cleaningStatus + '\'' +
                ", maids=" + maids +
                ", relBetweenRoomsBooking=" + relBetweenRoomsBooking +
                '}';
    }
}
