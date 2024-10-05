package com.project.hotel.service;

import com.project.hotel.models.AllServices;
import com.project.hotel.models.Maids;
import com.project.hotel.repositories.MaidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class MaidsService {
    private final MaidsRepository maidsRepository;
    @Autowired
    public MaidsService(MaidsRepository maidsRepository) {
        this.maidsRepository = maidsRepository;
    }



    public Maids findOne(int id){
        Optional<Maids> foundMaids =  maidsRepository.findById(id);
        return foundMaids.orElse(null);
    }

    public List<Maids> findAll(){
        return  maidsRepository.findAll();
    }
    //
    public Maids saveService(Maids maids){
        return  maidsRepository.save(maids);
    }

    public void deleteById(int id){
        maidsRepository.deleteById(id);
    }

    @Transactional
    public void save(Maids maids) {
        maidsRepository.save(maids);
    }


    @Transactional
    public void delete(int id) {
        maidsRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Maids updatedMaids) {
        updatedMaids.setMaidId(id);
        maidsRepository.save(updatedMaids);
    }
}
