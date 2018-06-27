package com.example.laporapi.person.petugas;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authorities {
    @Id
    private String username;

    private String authority = "ADMIN";

    public Authorities() {
    }

    public Authorities(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
