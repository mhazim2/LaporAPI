package com.example.laporapi.person.petugas;

import com.example.laporapi.exceptionhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PetugasController{

    private PetugasRepository petugasRepository;

    @Autowired
    public PetugasController(PetugasRepository petugasRepository) {
        this.petugasRepository = petugasRepository;
    }

    @GetMapping("/petugas")
    public List<Petugas> index() {
        return petugasRepository.findAll();
    }

    @GetMapping("/petugas/{id}")
    public Petugas show(@PathVariable(value = "id") Long id) {
        return petugasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID" + id.toString() + "Not Found"));
    }

    @PostMapping("/petugas")
    public Petugas create(@Valid @RequestBody Petugas petugas) {
        return petugasRepository.save(petugas);
    }

    @PutMapping("/petugas/{id}")
    public Petugas update(@PathVariable(value = "id") Long id, @RequestBody Petugas body) {
        Petugas petugas = petugasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID" + id.toString() + "Not Found"));
        petugas.setNama(body.getNama());
        petugas.setJabatan(body.getJabatan());
        petugas.setPassword(body.getPassword());
        petugas.setUsername(body.getUsername());
        petugas.setEmail(body.getEmail());
        petugas.setNo_hp(body.getNo_hp());
        return petugasRepository.save(petugas);
    }

    @DeleteMapping("/petugas/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        Petugas petugas = petugasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID" + id.toString() + "Not Found"));
        petugasRepository.delete(petugas);
    }
}