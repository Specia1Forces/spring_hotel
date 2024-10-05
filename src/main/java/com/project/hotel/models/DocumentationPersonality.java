package com.project.hotel.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Documentation personality")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class DocumentationPersonality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Documentation personality ID")
    private int documentationPersonalityId;
    @Column(name = "Series")
    private int series;
    @Column(name = "Number")
    private int Number;
    @OneToOne
    @JoinColumn(name="Client of hotel_Client ID",referencedColumnName ="Client ID" )
    private ClientOfHotel clientOfHotel3;

    @Override
    public String toString() {
        return "DocumentationPersonality{" +
                "documentationPersonalityId=" + documentationPersonalityId +
                ", series=" + series +
                ", Number=" + Number +
                ", clientOfHotel3=" + clientOfHotel3 +
                ", typeOfDocument=" + typeOfDocument +
                '}';
    }

    @OneToOne
    @JoinColumn(name="Type of document_Document type ID",referencedColumnName ="Document type ID" )
    private TypeOfDocument typeOfDocument;


}
