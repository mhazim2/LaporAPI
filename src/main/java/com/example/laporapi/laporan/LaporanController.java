package com.example.laporapi.laporan;

import com.example.laporapi.exceptionhandler.ResourceNotFoundException;
import com.example.laporapi.filemanager.FileStorageService;
import com.example.laporapi.person.pelapor.Pelapor;
import com.example.laporapi.person.pelapor.PelaporRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LaporanController {

    private LaporanRepository laporanRepository;
    private FileStorageService fileStorageService;

    public LaporanController() {
    }

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
//        String fileName = fileStorageService.storeFile(laporan.getFoto(), laporan.getId());
//        laporan.setFoto(fileName);
        return laporanRepository.save(laporan);
    }

    @GetMapping("/laporan/{id}")
    public Laporan show(@PathVariable(value = "id") Long id){
        return laporanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id "+id.toString()+" not found"));
    }

    @GetMapping("/laporan/pelapor/{id}")
    public List<Laporan> showLaporansPelapor(@PathVariable(value = "id") Long id){
        return laporanRepository.findByPelaporId(id);//orElseThrow(() -> new ResourceNotFoundException("Id "+id.toString()+" not found"));
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
