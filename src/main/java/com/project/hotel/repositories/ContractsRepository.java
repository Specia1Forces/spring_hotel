package com.project.hotel.repositories;

import com.project.hotel.models.ClientOfHotel;
import com.project.hotel.models.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractsRepository extends JpaRepository<Contracts, Integer> {
}
