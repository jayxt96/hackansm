package com.hackathon.hackansm.controller;

import com.hackathon.hackansm.dao.DrugDao;
import com.hackathon.hackansm.model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class DrugController {

    @Autowired
    private DrugDao drugDao;
    //Drugs -> select *
    @GetMapping(value = "Drugs")
    public List<Drug> listDrugs(){
        return drugDao.findAll();
    }

    //Drugs/{id}
    @GetMapping(value = "Drugs/{id}")
    public Drug displayDrug(@PathVariable int id){
        //Drug drug = new Drug(id, new String("doliprane"), new String("douleurs et fièvre"));
        return drugDao.findById(id);
    }
    @PostMapping(value="/Drugs")
    public ResponseEntity<Void> addDrug(@RequestBody Drug drug){
        Drug drug1=drugDao.save(drug);
        if(drug1==null){
            return ResponseEntity.noContent().build();
        }
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(drug1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}

