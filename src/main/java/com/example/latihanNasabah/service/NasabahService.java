package com.example.latihanNasabah.service;

import com.example.latihanNasabah.dao.NasabahDao;
import com.example.latihanNasabah.entity.*;
import com.example.latihanNasabah.model.Nasabah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class NasabahService {
    @Autowired
    NasabahDao nasabahDao;

    public BaseResponse postNasabah(PostNasabahRequest nasabah){
        Nasabah nasabah1 = new Nasabah();
        BaseResponse response = new BaseResponse();

        nasabah1.setAlamat(nasabah.getNama());
        nasabah1.setNama(nasabah.getNama());
        nasabah1.setNoTelepon(nasabah.getNoTelepon());
        nasabah1.setTlgLahir(nasabah.getTglLahir());
        nasabahDao.save(nasabah1);

        response.setErrorCode("00");
        response.setErrorMessage("Nasabah Berhasil DItambahkan");
        return response;
    }

    public GetNasabahResponse editNasabah(Integer id, PutNasabahRequest input){

        //BaseResponse response = new BaseResponse();
        GetNasabahResponse response = new GetNasabahResponse();
        if(!nasabahDao.existsById(id))
        {
            response.setErrorCode("99");
            response.setErrorMessage("Nasabah Tidak Ditemukan");
            return response;
        }

        Nasabah nasabahFound = nasabahDao.findById(id).get();
        if(input.getAlamat()!=null)
            nasabahFound.setAlamat(input.getAlamat());
        if(input.getNama()!=null)
            nasabahFound.setNama(input.getNama());
        if(input.getNoTelepon()!=null)
            nasabahFound.setNoTelepon(input.getNoTelepon());
        if(input.getTglLahir()!=null)
            nasabahFound.setTlgLahir(input.getTglLahir());

        nasabahDao.save(nasabahFound);
        Nasabah nasabah = nasabahDao.findById(id).get();
        response.setErrorCode("00");
        response.setErrorMessage("Nasabah Berhasil Diedit");
        response.setNama(nasabah.getNama());
        response.setTglLahir(nasabah.getTlgLahir());
        response.setAlamat(nasabah.getAlamat());
        return response;
    }

    public GetNasabahResponse getNasabah(Integer id){
        GetNasabahResponse response = new GetNasabahResponse();

        if(!nasabahDao.existsById(id))
        {
            response.setErrorCode("99");
            response.setErrorMessage("Nasabah Tidak Ditemukan");
            return  response;
        }

        Nasabah nasabah = nasabahDao.findById(id).get();

        response.setNama(nasabah.getNama());
        response.setTglLahir(nasabah.getTlgLahir());
        response.setAlamat(nasabah.getAlamat());
        response.setErrorCode("00");
        response.setErrorMessage("Nasabah Ditemukan");
        return response;
    }

    public BaseResponse deleteNasabah(Integer id){
        BaseResponse response = new BaseResponse();

        if(!nasabahDao.existsById(id))
        {
            response.setErrorCode("99");
            response.setErrorMessage("Nasabah Tidak Ditemukan");
            return  response;
        }

        nasabahDao.deleteById(id);
        response.setErrorCode("00");
        response.setErrorMessage("Nasabah Berhasil Dihapus");
        return response;
    }

    public List<Nasabah> findAll(){
        return nasabahDao.findAll();
    }

    public GetNasabahResponseList listNasabah(){
        GetNasabahResponseList responseList = new GetNasabahResponseList();

        List<Nasabah> nasabahs = nasabahDao.findAll();
        responseList.setNasabahList(nasabahs);
        responseList.setErrorCode("00");
        responseList.setErrorMessage("Berhasil Tampilkan");
        return responseList;
    }

}
