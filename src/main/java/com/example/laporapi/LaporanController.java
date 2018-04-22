package com.example.laporapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LaporanController {

    private LaporanRepository laporanRepository;

    @Autowired
    public LaporanController(LaporanRepository laporanRepository) {
        this.laporanRepository = laporanRepository;
    }

    @GetMapping("/laporan")
    public List<Laporan> index() {
        return laporanRepository.findAll();
    }

    @PostMapping("/laporan")
    public Laporan create(@Valid @RequestBody Laporan laporan) {
        return laporanRepository.save(laporan);
    }
}
