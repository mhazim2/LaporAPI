package com.example.laporapi;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Table(name = "pelapor")
@EntityListeners(AuditingEntityListener.class)
public class Pelapor extends Person{
    private String nim;

    public Pelapor() {
    }

    public Pelapor(Long id, String nama, String email, String no_hp, String nim) {
        super(id, nama, email, no_hp);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public String toString() {
        return "Pelapor{" +
                "nim='" + nim + '\'' +
                '}';
    }
}
