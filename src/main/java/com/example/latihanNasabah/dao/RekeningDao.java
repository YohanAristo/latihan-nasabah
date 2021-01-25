package com.example.latihanNasabah.dao;

import com.example.latihanNasabah.model.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RekeningDao extends JpaRepository<Rekening, Integer> {
}
