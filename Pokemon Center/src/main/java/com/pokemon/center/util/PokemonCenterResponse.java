package com.pokemon.center.util;

import com.pokemon.center.utilities.response.KeyResponseInterface;

public enum PokemonCenterResponse implements KeyResponseInterface {
    SUCCESSFUL_TRANSACTION("SUCCESSFUL_TRANSACTION"),
    NO_RESULT_FOUND_BY_ID("NO_RESULT_FOUND_BY_ID"),
    INVALID_IDENTIFICATION("INVALID_IDENTIFICATION"),
    INVALID_PERSON_CREATION_PARAMS("INVALID_PERSON_CREATION_PARAMS"),
    ROLE_NOT_FOUND("ROLE_NOT_FOUND"),
    IDENTIFICATION_ALREADY_USED("IDENTIFICATION_ALREADY_USED"),
    INVALID_SYMPTOM_CREATION_PARAMS("INVALID_SYMPTOM_CREATION_PARAMS"),
    SYMPTOM_NOT_FOUND("SYMPTOM_NOT_FOUND"),
    INVALID_TREATMENT_CREATION_PARAMS("INVALID_TREATMENT_CREATION_PARAMS"),
    TREATMENT_NOT_FOUND("TREATMENT_NOT_FOUND");
    public final String key;

    PokemonCenterResponse(String key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return key;
    }

}
