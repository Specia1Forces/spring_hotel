package com.project.hotel.service;

import com.project.hotel.models.AllServices;
import com.project.hotel.models.CleaningSchedule;
import com.project.hotel.repositories.CleaningScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CleaningScheduleService {
    private final CleaningScheduleRepository  cleaningScheduleRepository;
    @Autowired
    public CleaningScheduleService(CleaningScheduleRepository cleaningScheduleRepository) {
        this.cleaningScheduleRepository = cleaningScheduleRepository;
    }

    public CleaningSchedule findOne(int id){
        Optional<CleaningSchedule> foundPerson = cleaningScheduleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public List<CleaningSchedule> findAll(){
        return cleaningScheduleRepository.findAll();
    }
    //
    public CleaningSchedule saveService(CleaningSchedule cleaningSchedule){
        return cleaningScheduleRepository.save(cleaningSchedule);
    }

    public void deleteById(int id){
        cleaningScheduleRepository.deleteById(id);
    }

    @Transactional
    public void save(CleaningSchedule cleaningSchedule) {
        cleaningScheduleRepository.save(cleaningSchedule);
    }


    @Transactional
    public void delete(int id) {
        cleaningScheduleRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, CleaningSchedule updatedCleaningSchedule) {
        updatedCleaningSchedule.setCleaningScheduleId(id);
        cleaningScheduleRepository.save(updatedCleaningSchedule);
    }
}
