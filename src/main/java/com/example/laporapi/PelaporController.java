package com.example.laporapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PelaporController {

    private PelaporRepository pelaporRepository;

    @Autowired
    public PelaporController(PelaporRepository pelaporRepository) {
        this.pelaporRepository = pelaporRepository;
    }
}
