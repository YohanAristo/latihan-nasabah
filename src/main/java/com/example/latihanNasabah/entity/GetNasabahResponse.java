package com.example.latihanNasabah.entity;

import com.example.latihanNasabah.model.Nasabah;

import java.util.List;

public class GetNasabahResponse extends BaseResponse{
    private String nama;
    private String alamat;
    private String tglLahir;

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

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }
}
