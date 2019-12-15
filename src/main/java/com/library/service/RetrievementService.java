package com.library.service;


import com.library.entity.Retrievement;
import com.library.repository.RetrievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RetrievementService {
    @Autowired
    private RetrievementRepository retrievementRepository;

    public Retrievement findById(Integer id) throws Exception {
        return retrievementRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        retrievementRepository.deleteById(id);
        return "Retrievement number " + id + " has been deleted!";
    }

    public Retrievement changeById(Integer id,Retrievement retrievement) throws Exception {
        return retrievementRepository.findById(id)
                .map(newretrievement-> {
                    newretrievement.setId(retrievement.getId());
                    newretrievement.setBooks(retrievement.getBooks());
                    newretrievement.setRetrievementDate(retrievement.getRetrievementDate());
                    newretrievement.setUserEmail(retrievement.getUserEmail());
                    return retrievementRepository.save(retrievement);
                }).orElseThrow( Exception::new);
    }

    public Retrievement createRetrievement(Retrievement retrievement)  {
        return retrievementRepository.save(retrievement);
    }

    public List<Retrievement> getAll(){
        return retrievementRepository.findAll();
    }

}