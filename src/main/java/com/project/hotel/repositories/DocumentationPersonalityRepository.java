package com.project.hotel.repositories;

import com.project.hotel.models.DocumentationPersonality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentationPersonalityRepository extends JpaRepository<DocumentationPersonality, Integer> {
}
