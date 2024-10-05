package com.project.hotel.repositories;

import com.project.hotel.models.PaymentForAdditionalServices;
import com.project.hotel.models.RelBetweenRoomsBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelBetweenRoomsBookingRepository extends JpaRepository<RelBetweenRoomsBooking, Integer> {
}
