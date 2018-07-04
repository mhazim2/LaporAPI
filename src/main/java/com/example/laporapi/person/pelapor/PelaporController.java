package com.example.laporapi.person.pelapor;

import com.example.laporapi.exceptionhandler.ResourceNotFoundException;
import com.example.laporapi.laporan.Laporan;
import com.example.laporapi.laporan.LaporanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PelaporController {

    private PelaporRepository pelaporRepository;
    private LaporanRepository laporanRepository;

    @Autowired
    public PelaporController(PelaporRepository pelaporRepository, LaporanRepository laporanRepository) {
        this.pelaporRepository = pelaporRepository;
        this.laporanRepository = laporanRepository;
    }

    @GetMapping("/pelapor")
    public List<Pelapor> index(){
        return pelaporRepository.findAll();
    }

    @GetMapping("/pelapor/{id}")
    public Pelapor show(@PathVariable(value = "id") Long id){
        return pelaporRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id "+id.toString()+" not found"));
    }

    @GetMapping("/pelapor/nim/{nim}")
    public Pelapor showByNIM(@PathVariable(value = "nim") String nim){
        return pelaporRepository.findByNim(nim);
    }

    @PostMapping("/pelapor")
    public Pelapor create(@Valid @RequestBody Pelapor pelapor){
        return pelaporRepository.save(pelapor);
    }

    @PutMapping("/pelapor/{id}")
    public Pelapor update(@PathVariable(value = "id") Long id, @Valid @RequestBody Pelapor body){
        Pelapor pelapor = pelaporRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id "+id.toString()+" not found"));
        pelapor.setNim(body.getNim());
        pelapor.setNama(body.getNama());
        pelapor.setEmail(body.getEmail());
        pelapor.setNo_hp(body.getNo_hp());
        return pelaporRepository.save(pelapor);
    }

    @DeleteMapping("/pelapor/{id}")
    public void delete(@PathVariable Long id){
        Pelapor pelapor = pelaporRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id "+id.toString()+" not found"));
        List<Laporan> laporans = laporanRepository.findByPelaporId(id);
        for (Laporan temp : laporans) {
            laporanRepository.delete(temp);
        }
        pelaporRepository.delete(pelapor);
    }
}
