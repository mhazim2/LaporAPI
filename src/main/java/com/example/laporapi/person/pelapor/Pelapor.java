package com.example.laporapi.person.pelapor;

import com.example.laporapi.laporan.Laporan;
import com.example.laporapi.person.Person;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.awt.print.Book;
import java.util.List;

@Entity
@Table(name = "pelapor")
@EntityListeners(AuditingEntityListener.class)
public class Pelapor extends Person {

    @NotBlank
    @Column(name = "nim")
    private String nim;

    public Pelapor() {
    }

    public Pelapor(@NotBlank String nama, @NotBlank String email, @NotBlank String no_hp, @NotBlank String nim) {
        super(nama, email, no_hp);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
