package com.project.hotel.service;

import com.project.hotel.models.TechnicalMaintenancePersonnel;
import com.project.hotel.repositories.PaymentForAdditionalServicesRepository;
import com.project.hotel.repositories.TechnicalMaintenancePersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PaymentForAdditionalServicesService {
    /*
    private final PaymentForAdditionalServicesRepository paymentForAdditionalServicesRepository;
    @Autowired
    public PaymentForAdditionalServicesService(PaymentForAdditionalServicesRepository paymentForAdditionalServicesRepository) {
        this.paymentForAdditionalServicesRepository = paymentForAdditionalServicesRepository;
    }




    public TechnicalMaintenancePersonnel findOne(int id){
        Optional<TechnicalMaintenancePersonnel> foundPerson = paymentForAdditionalServicesRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public List<TechnicalMaintenancePersonnel> findAll(){
        return paymentForAdditionalServicesRepository.findAll();
    }
    //
    public TechnicalMaintenancePersonnel saveService(TechnicalMaintenancePersonnel technicalMaintenancePersonnel){
        return paymentForAdditionalServicesRepository.save(technicalMaintenancePersonnel);
    }

    public void deleteById(int id){
        paymentForAdditionalServicesRepository.deleteById(id);
    }

    @Transactional
    public void save(TechnicalMaintenancePersonnel technicalMaintenancePersonnel) {
        paymentForAdditionalServicesRepository.save(technicalMaintenancePersonnel);
    }


    @Transactional
    public void delete(int id) {
        paymentForAdditionalServicesRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, TechnicalMaintenancePersonnel updatedTechnicalMaintenancePersonnel) {
        updatedTechnicalMaintenancePersonnel.setCollaboratorMaintenanceID(id);
        paymentForAdditionalServicesRepository.save(updatedTechnicalMaintenancePersonnel);
    }

     */
}
