package com.example.laporapi.person.petugas;

import com.example.laporapi.person.Person;
import sun.plugin.util.UserProfile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "petugas")
public class Petugas extends Person {

    @NotBlank
    @Column(name = "username")
    private String username;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "jabatan")
    private String jabatan;

    public Petugas() {
    }

    public Petugas(@NotBlank String nama, @NotBlank String email, @NotBlank String no_hp, @NotBlank String username, @NotBlank String password, @NotBlank String jabatan) {
        super(nama, email, no_hp);
        this.username = username;
        this.password = password;
        this.jabatan = jabatan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public String toString() {
        return "Petugas{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jabatan='" + jabatan + '\'' +
                '}';
    }
}
