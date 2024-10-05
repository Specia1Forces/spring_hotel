package com.project.hotel.service;

import com.project.hotel.models.Booking;
import com.project.hotel.models.ClientOfHotel;
import com.project.hotel.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookingService {
    private final BookingRepository bookingRepository;
    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }



    public Booking findOne(int id){
        Optional<Booking> foundPerson = bookingRepository.findById(id);

        return foundPerson.orElse(null);
    }

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }
    //
    public Booking saveService(Booking booking){
        return bookingRepository.save(booking);
    }

    public void deleteById(int id){
        bookingRepository.deleteById(id);
    }

    @Transactional
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }


    @Transactional
    public void delete(int id) {
        bookingRepository.deleteById(id);
    }

    @Transactional
    public void update(int id,Booking updatedBooking) {
        updatedBooking.setReservationId(id);
        bookingRepository.save(updatedBooking);
    }
}
