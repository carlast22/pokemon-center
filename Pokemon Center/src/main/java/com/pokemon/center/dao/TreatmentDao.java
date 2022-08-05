package com.pokemon.center.dao;

import com.pokemon.center.dao.repository.TreatmentRepository;
import com.pokemon.center.persistence.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TreatmentDao {

    @Autowired
    TreatmentRepository treatmentRepository;

    public Treatment create(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public Treatment findById(int treatmentId) {
        return treatmentRepository.findTreatmentByTreId(treatmentId);
    }

    public List<Treatment> findByName(String treatmentName) {
        return treatmentRepository.findAllByTreNameIgnoreCaseContains(treatmentName);
    }
}
