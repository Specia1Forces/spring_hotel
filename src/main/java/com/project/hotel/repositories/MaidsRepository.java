package com.project.hotel.repositories;

import com.project.hotel.models.DocumentationPersonality;
import com.project.hotel.models.Maids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaidsRepository extends JpaRepository<Maids, Integer> {
}
