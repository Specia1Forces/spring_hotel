package com.project.hotel.repositories;

import com.project.hotel.models.MaintenanceLog;
import com.project.hotel.models.PaymentForAdditionalServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentForAdditionalServicesRepository extends JpaRepository<PaymentForAdditionalServices, Integer> {
}
