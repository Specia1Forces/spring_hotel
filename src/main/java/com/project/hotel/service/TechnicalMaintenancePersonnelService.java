package com.project.hotel.service;

import com.project.hotel.models.AllServices;
import com.project.hotel.models.TechnicalMaintenancePersonnel;
import com.project.hotel.repositories.AllServicesRepository;
import com.project.hotel.repositories.TechnicalMaintenancePersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TechnicalMaintenancePersonnelService {
    private final TechnicalMaintenancePersonnelRepository technicalMaintenancePersonnelRepository;
    @Autowired
    public TechnicalMaintenancePersonnelService(TechnicalMaintenancePersonnelRepository technicalMaintenancePersonnelRepository) {
        this.technicalMaintenancePersonnelRepository = technicalMaintenancePersonnelRepository;
    }

    public TechnicalMaintenancePersonnel findOne(int id){
        Optional<TechnicalMaintenancePersonnel> foundPerson = technicalMaintenancePersonnelRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public List<TechnicalMaintenancePersonnel> findAll(){
        return technicalMaintenancePersonnelRepository.findAll();
    }
    //
    public TechnicalMaintenancePersonnel saveService(TechnicalMaintenancePersonnel technicalMaintenancePersonnel){
        return technicalMaintenancePersonnelRepository.save(technicalMaintenancePersonnel);
    }

    public void deleteById(int id){
        technicalMaintenancePersonnelRepository.deleteById(id);
    }

    @Transactional
    public void save(TechnicalMaintenancePersonnel technicalMaintenancePersonnel) {
        technicalMaintenancePersonnelRepository.save(technicalMaintenancePersonnel);
    }


    @Transactional
    public void delete(int id) {
        technicalMaintenancePersonnelRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, TechnicalMaintenancePersonnel updatedTechnicalMaintenancePersonnel) {
        updatedTechnicalMaintenancePersonnel.setCollaboratorMaintenanceID(id);
        technicalMaintenancePersonnelRepository.save(updatedTechnicalMaintenancePersonnel);
    }
}
