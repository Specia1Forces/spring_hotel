package com.project.hotel.service;

import com.project.hotel.models.Maids;
import com.project.hotel.repositories.MaidsRepository;
import com.project.hotel.repositories.RoomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RoomCategoryService {
    /*
    private final RoomCategoryRepository roomCategoryRepository;
    @Autowired
    public RoomCategoryService(RoomCategoryRepository roomCategoryRepository) {
        this.roomCategoryRepository = roomCategoryRepository;
    }


    public Maids findOne(int id){
        Optional<Maids> foundMaids =  roomCategoryRepository.findById(id);
        return foundMaids.orElse(null);
    }

    public List<Maids> findAll(){
        return   roomCategoryRepository.findAll();
    }
    //
    public Maids saveService(Maids maids){
        return   roomCategoryRepository.save(maids);
    }

    public void deleteById(int id){
        roomCategoryRepository.deleteById(id);
    }

    @Transactional
    public void save(Maids maids) {
        roomCategoryRepository.save(maids);
    }


    @Transactional
    public void delete(int id) {
        roomCategoryRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Maids updatedMaids) {
        updatedMaids.setMaidId(id);
        roomCategoryRepository.save(updatedMaids);
    }

     */
}
