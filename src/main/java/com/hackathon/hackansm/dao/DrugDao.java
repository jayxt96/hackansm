package com.hackathon.hackansm.dao;

import com.hackathon.hackansm.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugDao extends JpaRepository<Drug, Integer> {
    Drug findById(int id);
}
