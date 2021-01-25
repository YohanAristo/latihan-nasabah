package com.example.latihanNasabah.rest;

import com.example.latihanNasabah.entity.*;
import com.example.latihanNasabah.model.Nasabah;
import com.example.latihanNasabah.model.Rekening;
import com.example.latihanNasabah.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RekeningRest {
    @Autowired
    RekeningService rekeningService;

    @PostMapping(value = "/rekening/createRekening")
    public BaseResponse createRekening(@RequestBody PostRekeningRequest rek){
        return rekeningService.postRekening(rek);
    }

    @GetMapping(value = "/rekening/{no-rekening}")
    public GetRekeningResponse getRekening(@PathVariable(value = "no-rekening") Integer noRekening){
        return rekeningService.getRekening(noRekening);
    }

    @DeleteMapping(value = "/rekening/delete/{no-rekening}")
    public BaseResponse deleteRekening(@PathVariable(value = "no-rekening") Integer noRekening){
        return rekeningService.deleteRekening(noRekening);
    }

    @PutMapping(value = "/rekening/edit/{no-rekening}")
    public BaseResponse editRekening(@PathVariable(value = "no-rekening") Integer noRekening, @RequestBody PutRekeningRequest rekening){
        return rekeningService.editRekening(noRekening, rekening);
    }

    @GetMapping(value = "/rekening")
    public ResponseEntity<List<Rekening>> listRekening(){
        return ResponseEntity.ok(rekeningService.findAll());
    }

    @GetMapping(value = "/rekening1")
    public GetRekeningResponseList showRekening(){
        return rekeningService.listRekening();
    }
}
