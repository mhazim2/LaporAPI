package com.example.laporapi;

public class Petugas extends Person{
    private String username;
    private String password;
    private String jabatan;

    public Petugas() {
    }

    public Petugas(Long id, String nama, String email, String no_hp, String username, String password, String jabatan) {
        super(id, nama, email, no_hp);
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
