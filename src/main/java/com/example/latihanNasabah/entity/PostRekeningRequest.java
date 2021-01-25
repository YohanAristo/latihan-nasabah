package com.example.latihanNasabah.entity;

import java.util.Date;

public class PostRekeningRequest {
    private String jenisRekening;
    private int idNasabah;
    private double jumlahTabungan;


    public String getJenisRekening() {
        return jenisRekening;
    }

    public void setJenisRekening(String jenisRekening) {
        this.jenisRekening = jenisRekening;
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
