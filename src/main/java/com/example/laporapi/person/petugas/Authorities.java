package com.example.laporapi.person.petugas;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Authorities {
    @Id
    @NotNull
    private String username;

    @NotNull
    private String authority = "ROLE_ADMIN";

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    public Authorities() {
    }

    public Authorities(String username, Users users) {
        this.username = username;
        this.users = users;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
