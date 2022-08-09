package com.pokemon.center.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SpriteModel {
    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    @JsonProperty("back_default")
    private String backDefault;
    @JsonProperty("front_default")
    private String frontDefault;
}
