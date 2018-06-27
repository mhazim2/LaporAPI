package com.example.laporapi.laporan;

import com.example.laporapi.person.pelapor.Pelapor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.internal.constraintvalidators.bv.NotBlankValidator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "laporan")
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class Laporan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelapor_id", nullable = false)
    protected Pelapor pelapor;

    @NotBlank
    protected String jenis_laporan;

    @NotBlank
    protected String deskripsi;

    @NotBlank
    protected String tempat;

    @NotBlank
    protected String foto;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date updatedAt;

    protected int status;

    public Laporan() {
        status = 2;
    }

    public Laporan(Pelapor pelapor, @NotBlank String jenis_laporan, @NotBlank String deskripsi, @NotBlank String tempat, @NotBlank String foto, Date createdAt, Date updatedAt, int status) {
        this.pelapor = pelapor;
        this.jenis_laporan = jenis_laporan;
        this.deskripsi = deskripsi;
        this.tempat = tempat;
        this.foto = foto;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pelapor getPelapor() {
        return pelapor;
    }

    public void setPelapor(Pelapor pelapor) {
        this.pelapor = pelapor;
    }

    public String getJenis_laporan() {
        return jenis_laporan;
    }

    public void setJenis_laporan(String jenis_laporan) {
        this.jenis_laporan = jenis_laporan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
