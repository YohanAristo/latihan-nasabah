package com.example.latihanNasabah.entity;

import java.util.Date;

public class GetRekeningResponse extends BaseResponse{
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
