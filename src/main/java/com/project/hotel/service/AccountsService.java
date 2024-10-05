package com.project.hotel.service;

import com.project.hotel.models.Accounts;
import com.project.hotel.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class AccountsService {
    private final AccountsRepository accountsRepository;
    @Autowired
    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }




    public Accounts findOne(int id){
        Optional<Accounts> foundPerson = accountsRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public List<Accounts> findAll(){
        return accountsRepository.findAll();
    }
    //
    public Accounts saveService(Accounts user){
        return accountsRepository.save(user);
    }

    public void deleteById(int id){
        accountsRepository.deleteById(id);
    }

    @Transactional
    public void save(Accounts person) {
        accountsRepository.save(person);
    }


    @Transactional
    public void delete(int id) {
        accountsRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Accounts updatedAllServices) {
        updatedAllServices.setAccountNumber(id);
        accountsRepository.save(updatedAllServices);
    }
}
