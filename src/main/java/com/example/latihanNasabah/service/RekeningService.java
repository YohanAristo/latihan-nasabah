package com.example.latihanNasabah.service;

import com.example.latihanNasabah.dao.NasabahDao;
import com.example.latihanNasabah.dao.RekeningDao;
import com.example.latihanNasabah.entity.*;
import com.example.latihanNasabah.model.Nasabah;
import com.example.latihanNasabah.model.Rekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class RekeningService {

    private int countId;
    private String countIdTemp;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RekeningDao rekeningDao;

    @Autowired
    NasabahDao nasabahDao;

    public int checkTahapanRow(){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) from rekening WHERE jenis_rekening='tahapan' OR jenis_rekening='Tahapan'", Integer.class);
    }

    public int checkXpresiRow(){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) from rekening WHERE jenis_rekening='xpresi' OR jenis_rekening='Xpresi'", Integer.class);
    }


    public BaseResponse postRekening(PostRekeningRequest rekening){
        Rekening rekening1 = new Rekening();
        BaseResponse response = new BaseResponse();

        rekening1.setTglBuat(new Date());
        rekening1.setIdNasabah(rekening.getIdNasabah());
        rekening1.setJumlahTabungan(rekening.getJumlahTabungan());

        if(!nasabahDao.existsById(rekening.getIdNasabah())) {
            response.setErrorCode("99");
            response.setErrorMessage("Nasabah Tidak Ditemukan");
            return response;
        }


        if(rekening.getJenisRekening().equalsIgnoreCase("Tahapan") || rekening.getJenisRekening().equalsIgnoreCase("tahapan")){
            rekening1.setJenisRekening(rekening.getJenisRekening());
            countId = checkTahapanRow();
            countId = countId+1;
            String noRek = String.format("%d%09d", 1,countId);
            rekening1.setNoRekening(Integer.parseInt(noRek));

            rekeningDao.save(rekening1);

            response.setErrorCode("99");
            response.setErrorMessage("Rekening Berhasil Dibuat");
            return response;

        }
        else if(rekening.getJenisRekening().equalsIgnoreCase("Xpresi") || rekening.getJenisRekening().equalsIgnoreCase("xpresi")){
            rekening1.setJenisRekening(rekening.getJenisRekening());
            countId = checkXpresiRow();
            countId = countId+1;
            String noRek = String.format("%d%09d", 2,countId);
            rekening1.setNoRekening(Integer.parseInt(noRek));

            rekeningDao.save(rekening1);

            response.setErrorCode("99");
            response.setErrorMessage("Rekening Berhasil Dibuat");
            return response;
        }
        else {
            response.setErrorCode("99");
            response.setErrorMessage("Jenis Rekening Harus Xpresi atau Tahapan");
            return response;
        }

    }

    public GetRekeningResponse getRekening(Integer id){
        GetRekeningResponse response = new GetRekeningResponse();

        if(!rekeningDao.existsById(id))
        {
            response.setErrorCode("99");
            response.setErrorMessage("Rekening Tidak Ditemukan");
            return  response;
        }

        Rekening rekening = rekeningDao.findById(id).get();

        response.setNoRekening(rekening.getNoRekening());
        response.setJenisRekening(rekening.getJenisRekening());
        response.setIdNasabah(rekening.getIdNasabah());
        response.setErrorCode("00");
        response.setErrorMessage("Rekening Ditemukan");
        return response;
    }

    public BaseResponse deleteRekening(Integer id){
        BaseResponse response = new BaseResponse();

        if(!rekeningDao.existsById(id))
        {
            response.setErrorCode("99");
            response.setErrorMessage("Rekening Tidak Ditemukan");
            return  response;
        }

        rekeningDao.deleteById(id);
        response.setErrorCode("00");
        response.setErrorMessage("Rekening Berhasil Dihapus");
        return response;
    }

    public GetRekeningResponse editRekening(Integer id, PutRekeningRequest input){

        GetRekeningResponse response = new GetRekeningResponse();

        if(!rekeningDao.existsById(id))
        {
            response.setErrorCode("99");
            response.setErrorMessage("Rekening Tidak Ditemukan");
            return response;
        }

        Rekening rekeningFound = rekeningDao.findById(id).get();
        if(input.getJumlahTabungan() != 0)
            rekeningFound.setJumlahTabungan(input.getJumlahTabungan());

        rekeningDao.save(rekeningFound);
        Rekening rekening = rekeningDao.findById(id).get();
        response.setErrorCode("00");
        response.setErrorMessage("Rekening Berhasil Diedit");
        response.setJumlahTabungan(rekening.getJumlahTabungan());
        return response;
    }

    public List<Rekening> findAll(){
        return rekeningDao.findAll();
    }

    public GetRekeningResponseList listRekening(){
        GetRekeningResponseList responseList = new GetRekeningResponseList();

        List<Rekening> rekenings = rekeningDao.findAll();
        responseList.setRekeningList(rekenings);
        responseList.setErrorCode("00");
        responseList.setErrorMessage("Berhasil Tampilkan");
        return responseList;
    }

}
