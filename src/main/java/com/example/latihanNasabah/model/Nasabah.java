package com.example.latihanNasabah.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nasabah {
    @Id
    @GeneratedValue
    private int id;
    private String nama;
    private String alamat;
    private String tlgLahir;
    private String noTelepon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTlgLahir() {
        return tlgLahir;
    }

    public void setTlgLahir(String tlgLahir) {
        this.tlgLahir = tlgLahir;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
}
