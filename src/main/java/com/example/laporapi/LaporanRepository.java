package com.example.laporapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaporanRepository extends JpaRepository<Laporan, Long> {
}
