package com.hackathon.hackansm.dao;

import com.hackathon.hackansm.model.Drug;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DrugDaoImpl implements DrugDao{
    public static List<Drug> drugs = new ArrayList<>();
    static {
        drugs.add(new Drug(1, new String("doliprane"), new String("douleurs et fièvre")));
        drugs.add(new Drug(2, new String("smecta"), new String("indigestion")));
        drugs.add(new Drug(3, new String("antadys"), new String("règles douloureuses")));
    }

    @Override
    public List<Drug> findAll() {
        return drugs;
    }

    @Override
    public Drug findById(int id) {
        for (Drug drug : drugs) {
            if(drug.getId()==id){
                return drug;
            }
        }

        return null;
    }

    @Override
    public Drug save(Drug drug) {
        drugs.add(drug);
        return drug;
    }
}
