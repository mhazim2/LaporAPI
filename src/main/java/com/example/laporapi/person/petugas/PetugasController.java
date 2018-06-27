package com.example.laporapi.person.petugas;

import com.example.laporapi.exceptionhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PetugasController{

    private PetugasRepository petugasRepository;
    private UsersRepository usersRepository;
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    public PetugasController(PetugasRepository petugasRepository, UsersRepository usersRepository, AuthoritiesRepository authoritiesRepository) {
        this.petugasRepository = petugasRepository;
        this.usersRepository = usersRepository;
        this.authoritiesRepository = authoritiesRepository;
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
        petugas.setPassword(new BCryptPasswordEncoder().encode(petugas.getPassword()));
        usersRepository.save(new Users(petugas.getUsername(), petugas.getPassword()));
        authoritiesRepository.save(new Authorities(petugas.getUsername()));
        return petugasRepository.save(petugas);
    }

    @PutMapping("/petugas/{id}")
    public Petugas update(@PathVariable(value = "id") Long id, @RequestBody Petugas body) {
        Petugas petugas = petugasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID" + id.toString() + "Not Found"));
        petugas.setNama(body.getNama());
        petugas.setJabatan(body.getJabatan());
        petugas.setPassword(new BCryptPasswordEncoder().encode(body.getPassword()));
        petugas.setUsername(body.getUsername());
        petugas.setEmail(body.getEmail());
        petugas.setNo_hp(body.getNo_hp());
        usersRepository.save(usersRepository.findById(petugas.getUsername()).orElseThrow(() -> new ResourceNotFoundException("ID" + petugas.getUsername() + "Not Found")));
        authoritiesRepository.save(authoritiesRepository.findById(petugas.getUsername()).orElseThrow(() -> new ResourceNotFoundException("ID" + petugas.getUsername() + "Not Found")));
        return petugasRepository.save(petugas);
    }

    @DeleteMapping("/petugas/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        Petugas petugas = petugasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID" + id.toString() + "Not Found"));
        usersRepository.delete(usersRepository.findById(petugas.getUsername()).orElseThrow(() -> new ResourceNotFoundException("ID" + petugas.getUsername() + "Not Found")));
        authoritiesRepository.delete(authoritiesRepository.findById(petugas.getUsername()).orElseThrow(() -> new ResourceNotFoundException("ID" + petugas.getUsername() + "Not Found")));
        petugasRepository.delete(petugas);
    }
}