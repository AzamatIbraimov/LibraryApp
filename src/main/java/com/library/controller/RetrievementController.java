package com.library.controller;

import com.library.entity.Retrievement;
import com.library.service.RetrievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/retrievement")
public class RetrievementController {

    @Autowired
    RetrievementService retrievementService;

    @GetMapping("/{id}")
    public Retrievement getRetrievemetn(@PathVariable ("id") Integer id) throws Exception {
        return retrievementService.findById(id);
    }

    @PutMapping("/{id}")
    public Retrievement putRetrievement(@PathVariable ("id") Integer id ,@RequestBody Retrievement retrievement) throws Exception {
        return retrievementService.changeById(id,retrievement);
    }

    @GetMapping("/close/{id}/{comment}")
    public Retrievement closeRetrievement(@PathVariable ("id") Integer id,@PathVariable ("comment") String comment) throws Exception {
        return retrievementService.closeRetrievement(id,comment);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Retrievement postRetrievement(@RequestBody Retrievement retrievement) throws Exception {
        retrievementService.createRetrievement(retrievement);
        return retrievement;
    }

    @DeleteMapping("/{id}")
    public void deleteRetrievement(@PathVariable ("id") Integer id)
    {
        retrievementService.deleteById(id);
    }

    @GetMapping(value="/all")
    public List<Retrievement> getAllCategories() {
        return retrievementService.getAll();
    }
}