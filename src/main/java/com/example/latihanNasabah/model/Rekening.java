package com.example.latihanNasabah.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Rekening {
    @Id
    private int noRekening;
    private String jenisRekening;
    private Date tglBuat;
    private int idNasabah;
    private double jumlahTabungan;

    public int getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(int noRekening) {
        this.noRekening = noRekening;
    }

    public String getJenisRekening() {
        return jenisRekening;
    }

    public void setJenisRekening(String jenisRekening) {
        this.jenisRekening = jenisRekening;
    }

    public Date getTglBuat() {
        return tglBuat;
    }

    public void setTglBuat(Date tglBuat) {
        this.tglBuat = tglBuat;
    }

    public int getIdNasabah() {
        return idNasabah;
    }

    public void setIdNasabah(int idNasabah) {
        this.idNasabah = idNasabah;
    }

    public double getJumlahTabungan() {
        return jumlahTabungan;
    }

    public void setJumlahTabungan(double jumlahTabungan) {
        this.jumlahTabungan = jumlahTabungan;
    }
}
