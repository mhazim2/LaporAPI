package com.example.laporapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PelaporController {

    Pelapor pelapor;

    @Autowired
    public PelaporController(Pelapor pelapor) {
        this.pelapor = pelapor;
    }
}
