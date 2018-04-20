package com.example.laporapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetugasController {

    private PetugasRepository petugasRepository;

    @Autowired
    public PetugasController(PetugasRepository petugasRepository) {
        this.petugasRepository = petugasRepository;
    }
}