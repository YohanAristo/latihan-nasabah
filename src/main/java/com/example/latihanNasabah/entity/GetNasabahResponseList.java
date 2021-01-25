package com.example.latihanNasabah.entity;

import com.example.latihanNasabah.dao.NasabahDao;
import com.example.latihanNasabah.model.Nasabah;

import java.util.List;

public class GetNasabahResponseList extends BaseResponse{
    private List<Nasabah> nasabahList;

    public List<Nasabah> getNasabahList() {
        return nasabahList;
    }

    public void setNasabahList(List<Nasabah> nasabahList) {
        this.nasabahList = nasabahList;
    }
}
