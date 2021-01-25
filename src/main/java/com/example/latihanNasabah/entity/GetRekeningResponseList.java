package com.example.latihanNasabah.entity;

import com.example.latihanNasabah.model.Rekening;

import java.util.Date;
import java.util.List;

public class GetRekeningResponseList extends BaseResponse{
    private List<Rekening> rekeningList;

    public List<Rekening> getRekeningList() {
        return rekeningList;
    }

    public void setRekeningList(List<Rekening> rekeningList) {
        this.rekeningList = rekeningList;
    }
}
