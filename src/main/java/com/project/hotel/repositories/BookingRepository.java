package com.project.hotel.repositories;

import com.project.hotel.models.AllServices;
import com.project.hotel.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
