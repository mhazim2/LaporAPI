package com.example.laporapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/laporan/{id}")
    public Laporan update(@PathVariable(value = "id") Long id, @Valid @RequestBody Laporan body) {
        Laporan laporan = laporanRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Id " + id.toString() + " not found"));
        laporan.setDeskripsi(body.getDeskripsi());
        laporan.setFoto(body.getFoto());
        laporan.setJenis_laporan(body.getJenis_laporan());
        laporan.setStatus(body.getStatus());
        laporan.setTempat(body.getTempat());
        return laporan;
    }

    @DeleteMapping("/laporan/{id}")
    public void delete(@PathVariable Long id) {
        Laporan laporan = laporanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        laporanRepository.delete(laporan);
    }
}
