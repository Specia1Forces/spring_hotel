package com.project.hotel.models;
import jakarta.persistence.*;
import lombok.*;

/*
* Document type ID: INTEGER
Name: TINYTEXT*/
@Entity
@Table(name = "Type of document")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TypeOfDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Document type ID")
    private int documentTypeId;
    @Column(name = "Name")
    private String name;
    @OneToOne(mappedBy = "typeOfDocument")
    private DocumentationPersonality documentationPersonality;

    @Override
    public String toString() {
        return "TypeOfDocument{" +
                "documentTypeId=" + documentTypeId +
                ", name='" + name + '\'' +
                ", documentationPersonality=" + documentationPersonality +
                '}';
    }
}
