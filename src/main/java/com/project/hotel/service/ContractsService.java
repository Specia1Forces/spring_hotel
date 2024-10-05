package com.project.hotel.service;

import com.project.hotel.models.ClientOfHotel;
import com.project.hotel.models.Contracts;
import com.project.hotel.repositories.ClientOfHotelRepository;
import com.project.hotel.repositories.ContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class ContractsService {
    private final ContractsRepository contractsRepository;
    @Autowired


    public ContractsService(ContractsRepository contractsRepository) {
        this.contractsRepository = contractsRepository;
    }

    public Contracts findOne(int id){
        Optional<Contracts> foundPerson = contractsRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public List<Contracts> findAll(){
        return contractsRepository.findAll();
    }
    //
    public Contracts saveService(Contracts contracts){
        return contractsRepository.save(contracts);
    }

    public void deleteById(int id){
        contractsRepository.deleteById(id);
    }

    @Transactional
    public void save(Contracts contracts) {
        contractsRepository.save(contracts);
    }


    @Transactional
    public void delete(int id) {
        contractsRepository.deleteById(id);
    }

    @Transactional
    public void update(int id,Contracts updatedContracts) {
        updatedContracts.setContractNumber(id);
        contractsRepository.save(updatedContracts);
    }
}
