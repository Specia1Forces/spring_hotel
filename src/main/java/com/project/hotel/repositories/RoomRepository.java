package com.project.hotel.repositories;

import com.project.hotel.models.Room;
import com.project.hotel.models.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
