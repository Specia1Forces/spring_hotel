package com.project.hotel.repositories;

import com.project.hotel.models.RoomCategory;
import com.project.hotel.models.TechnicalMaintenancePersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalMaintenancePersonnelRepository extends JpaRepository<TechnicalMaintenancePersonnel, Integer> {
}
