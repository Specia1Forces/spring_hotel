package com.project.hotel.repositories;

import com.project.hotel.models.Booking;
import com.project.hotel.models.CleaningSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningScheduleRepository extends JpaRepository<CleaningSchedule, Integer> {
}
