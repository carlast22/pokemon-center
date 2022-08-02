package com.pokemon.center.service;

import com.pokemon.center.dao.SymptomDao;
import com.pokemon.center.params.SymptomParams;
import com.pokemon.center.persistence.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService {

    @Autowired
    SymptomDao symptomDao;

    public Symptom createSymptom(SymptomParams symptomParam){
        Symptom symptom = new Symptom();
        symptom.setSymName(symptomParam.getName().trim());
        symptom.setSymDescription(symptomParam.getDescription().trim());
        return symptomDao.createSymptom(symptom);
    }
    public Symptom updateSymptom(SymptomParams symptomParam){
        Symptom symptom = findById(symptomParam.getId());
        if(null != symptom){
            symptom.setSymName(symptomParam.getName());
            symptom.setSymDescription(symptomParam.getDescription());
        }
        return symptomDao.updateSymptom(symptom);
    }
    public List<Symptom> findAll(){
        return  symptomDao.findAll();
    }
    public Symptom findById(int id){
        return symptomDao.findById(id);
    }
    public List<Symptom> findByName(String symptomName){
        symptomName =  symptomName.trim();
        return symptomDao.findByName(symptomName);
    }
}
