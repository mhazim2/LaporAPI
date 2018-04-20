package com.example.laporapi;

abstract class Person {
    private Long id;
    private String nama;
    private String email;
    private String no_hp;

    public Person() {
    }

    public Person(Long id, String nama, String email, String no_hp) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.no_hp = no_hp;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", no_hp='" + no_hp + '\'' +
                '}';
    }
}
