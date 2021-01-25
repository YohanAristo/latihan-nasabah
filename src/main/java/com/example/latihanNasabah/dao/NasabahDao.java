package com.example.latihanNasabah.dao;

import com.example.latihanNasabah.model.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NasabahDao extends JpaRepository<Nasabah, Integer> {
}
