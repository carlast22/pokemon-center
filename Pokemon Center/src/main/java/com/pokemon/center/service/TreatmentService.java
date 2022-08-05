package com.pokemon.center.service;

import com.pokemon.center.dao.TreatmentDao;
import com.pokemon.center.params.TreatmentParams;
import com.pokemon.center.persistence.Treatment;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    @Autowired
    TreatmentDao treatmentDao;

    public Treatment create(TreatmentParams treatmentParams) {
        if (treatmentParams.getName().trim().isEmpty()) {
            throw new PokemonCenterException(PokemonCenterResponse.INVALID_TREATMENT_CREATION_PARAMS);
        }
        Treatment treatment = new Treatment();

        treatment.setTreName(treatmentParams.getName());
        treatment.setTreDescription(treatmentParams.getDescription());

        return treatmentDao.create(treatment);
    }

    public Treatment findById(int treatmentId) {
        Treatment treatment = treatmentDao.findById(treatmentId);
        if (null == treatment) {
            throw new PokemonCenterException(PokemonCenterResponse.TREATMENT_NOT_FOUND);
        }
        return treatment;
    }

    public List<Treatment> findByName(String treatmentName) {
        return treatmentDao.findByName(treatmentName);
    }
}
