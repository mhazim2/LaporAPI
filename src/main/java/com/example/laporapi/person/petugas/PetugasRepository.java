package com.example.laporapi.person.petugas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetugasRepository extends JpaRepository<Petugas, Long> {
}
