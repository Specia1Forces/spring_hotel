package com.project.hotel.repositories;

import com.project.hotel.models.Accounts;
import com.project.hotel.models.AllServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllServicesRepository extends JpaRepository<AllServices, Integer> {
}
