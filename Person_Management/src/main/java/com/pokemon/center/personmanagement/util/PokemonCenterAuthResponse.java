package com.pokemon.center.personmanagement.util;

import com.pokemon.center.utilities.response.KeyResponseInterface;

public enum PokemonCenterAuthResponse implements KeyResponseInterface {
    SUCCESSFUL_TRANSACTION("SUCCESSFUL_TRANSACTION"),
    INVALID_CREDENTIALS("INVALID_CREDENTIALS");

    public final String key;

    PokemonCenterAuthResponse(String key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return key;
    }

}
