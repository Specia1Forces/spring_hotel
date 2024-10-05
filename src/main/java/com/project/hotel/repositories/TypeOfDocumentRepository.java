package com.project.hotel.repositories;

import com.project.hotel.models.TechnicalMaintenancePersonnel;
import com.project.hotel.models.TypeOfDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfDocumentRepository extends JpaRepository<TypeOfDocument, Integer> {
}
