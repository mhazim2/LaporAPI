package com.example.laporapi.person.pelapor;

import com.example.laporapi.exceptionhandler.ResourceNotFoundException;
import com.example.laporapi.laporan.Laporan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PelaporController {

    private PelaporRepository pelaporRepository;

    @Autowired
    public PelaporController(PelaporRepository pelaporRepository) {
        this.pelaporRepository = pelaporRepository;
    }

    @GetMapping("/pelapor")
    public List<Pelapor> index(){
        return pelaporRepository.findAll();
    }

//    @GetMapping("/pelapor/laporan")
//    public List<Laporan> indexLaporans(){
//        List<Pelapor> pelapor = pelaporRepository.findAll();
//        return
//    }

    @GetMapping("/pelapor/{id}")
    public Pelapor show(@PathVariable(value = "id") Long id){
        return pelaporRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id "+id.toString()+" not found"));
    }

//    @GetMapping("/pelapor/{id}/laporan")
//    public List<Laporan> showLaporans(@PathVariable(value = "id") Long id){
//        Pelapor pelapor = pelaporRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id "+id.toString()+" not found"));
//        return pelapor.getLaporans();
//    }

    @PostMapping("/pelapor")
    public Pelapor create(@Valid @RequestBody Pelapor pelapor){
        /*String nama = body.get("nama");
        String email = body.get("email");
        String nim = body.get("nim");
        String no_hp = body.get("no_hp");
        return pelaporRepository.save(new Pelapor(nama,email,no_hp,nim));*/
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
        pelaporRepository.delete(pelapor);
    }
}
