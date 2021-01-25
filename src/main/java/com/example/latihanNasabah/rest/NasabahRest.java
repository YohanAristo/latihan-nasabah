package com.example.latihanNasabah.rest;

import com.example.latihanNasabah.entity.*;
import com.example.latihanNasabah.model.Nasabah;
import com.example.latihanNasabah.service.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NasabahRest {
    @Autowired
    NasabahService nasabahService;

    @PostMapping(value = "/nasabah/createNasabah")
    public BaseResponse createNasabah(@RequestBody PostNasabahRequest nasabah){
        return nasabahService.postNasabah(nasabah);
    }

    @GetMapping(value = "/nasabah/{id-nasabah}")
    public GetNasabahResponse getNasabah(@PathVariable(value = "id-nasabah") Integer idNasabah){
        return nasabahService.getNasabah(idNasabah);
    }

    @DeleteMapping(value = "/nasabah/delete/{id-nasabah}")
    public BaseResponse deleteNasabah(@PathVariable(value = "id-nasabah") Integer idNasabah){
        return nasabahService.deleteNasabah(idNasabah);
    }

    @PutMapping(value = "/nasabah/edit/{id-nasabah}")
    public BaseResponse editNasabah(@PathVariable(value = "id-nasabah") Integer idNasabah, @RequestBody PutNasabahRequest nasabah){
        return nasabahService.editNasabah(idNasabah, nasabah);
    }

    @GetMapping(value = "/nasabah")
    public ResponseEntity<List<Nasabah>> listNasabah(){
        return ResponseEntity.ok(nasabahService.findAll());
    }

    @GetMapping(value = "/nasabah1")
    public GetNasabahResponseList showNasabah(){
        return nasabahService.listNasabah();
    }
}
