package com.example.laporapi.person.petugas;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Users {
    @Id
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private boolean enabled = true;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petugas_id", nullable = false)
    private Petugas petugas;

    public Users() {
    }

    public Users(String username, String password, Petugas petugas) {
        this.username = username;
        this.password = password;
        this.petugas = petugas;
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

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Petugas getPetugas() {
        return petugas;
    }

    public void setPetugas(Petugas petugas) {
        this.petugas = petugas;
    }
}
