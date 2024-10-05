package com.project.hotel.service;

import com.project.hotel.models.ClientOfHotel;
import com.project.hotel.models.TypeOfDocument;
import com.project.hotel.repositories.ClientOfHotelRepository;
import com.project.hotel.repositories.TypeOfDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TypeOfDocumentService {
    private final TypeOfDocumentRepository typeOfDocumentRepository;
    @Autowired


    public TypeOfDocumentService(TypeOfDocumentRepository typeOfDocumentRepository) {
        this.typeOfDocumentRepository = typeOfDocumentRepository;
    }

    public TypeOfDocument findOne(int id){
        Optional< TypeOfDocument> foundPerson =  typeOfDocumentRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public List<TypeOfDocument> findAll(){
        return typeOfDocumentRepository.findAll();
    }
    //
    public TypeOfDocument saveService(TypeOfDocument typeOfDocument){
        return typeOfDocumentRepository.save(typeOfDocument);
    }

    public void deleteById(int id){
        typeOfDocumentRepository.deleteById(id);
    }

    @Transactional
    public void save(TypeOfDocument typeOfDocument) {
        typeOfDocumentRepository.save(typeOfDocument);
    }


    @Transactional
    public void delete(int id) {
        typeOfDocumentRepository.deleteById(id);
    }

    @Transactional
    public void update(int id,TypeOfDocument updatedTypeOfDocument) {
        updatedTypeOfDocument.setDocumentTypeId(id);
        typeOfDocumentRepository.save(updatedTypeOfDocument);
    }
}
