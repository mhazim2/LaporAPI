package com.example.laporapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelaporRepository extends JpaRepository<Pelapor, Long> {

}
