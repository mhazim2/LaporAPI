package com.example.laporapi;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pelapor")
@EntityListeners(AuditingEntityListener.class)
public class Pelapor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nama")
    private String nama;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "no_hp")
    private String no_hp;

    @NotBlank
    @Column(name = "nim")
    private String nim;

    public Pelapor() {
    }

    public Pelapor(@NotBlank String nama, @NotBlank String email, @NotBlank String no_hp, @NotBlank String nim) {
        this.nama = nama;
        this.email = email;
        this.no_hp = no_hp;
        this.nim = nim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
