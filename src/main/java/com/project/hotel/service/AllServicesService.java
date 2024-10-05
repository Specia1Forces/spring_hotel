package com.project.hotel.service;

import com.project.hotel.models.AllServices;
import com.project.hotel.repositories.AllServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AllServicesService {
    private final AllServicesRepository allServicesRepository;
    @Autowired
    public AllServicesService(AllServicesRepository allServicesRepository) {
        this.allServicesRepository = allServicesRepository;
    }

    public AllServices findOne(int id){
        Optional<AllServices> foundPerson = allServicesRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public List<AllServices> findAll(){
        return allServicesRepository.findAll();
    }
    //
    public AllServices saveService(AllServices user){
        return allServicesRepository.save(user);
    }

    public void deleteById(int id){
        allServicesRepository.deleteById(id);
    }

    @Transactional
    public void save(AllServices person) {
        allServicesRepository.save(person);
    }


    @Transactional
    public void delete(int id) {
        allServicesRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, AllServices updatedAllServices) {
        updatedAllServices.setServiceId(id);
        allServicesRepository.save(updatedAllServices);
    }
}
