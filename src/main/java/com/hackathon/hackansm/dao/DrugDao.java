package com.hackathon.hackansm.dao;

import com.hackathon.hackansm.model.Drug;

import java.util.List;

public interface DrugDao {
    public List<Drug> findAll();
    public Drug findById(int id);
    public Drug save(Drug drug);
}
