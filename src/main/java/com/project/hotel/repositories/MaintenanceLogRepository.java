package com.project.hotel.repositories;

import com.project.hotel.models.Maids;
import com.project.hotel.models.MaintenanceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceLogRepository extends JpaRepository<MaintenanceLog, Integer> {
}
