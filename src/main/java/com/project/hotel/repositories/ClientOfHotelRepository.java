package com.project.hotel.repositories;

import com.project.hotel.models.CleaningSchedule;
import com.project.hotel.models.ClientOfHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOfHotelRepository extends JpaRepository<ClientOfHotel, Integer> {
}
