package com.pokemon.center.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonSpeciesModel {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("is_baby")
    private Boolean isBaby;

    @JsonProperty("is_legendary")
    private Boolean isLegendary;

    @JsonProperty("is_mythical")
    private Boolean isMythical;

    @JsonProperty("color")
    private BaseModel color;

    @JsonProperty("habitat")
    private BaseModel habitat;

    @JsonProperty("shape")
    private BaseModel shape;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsBaby() {
        return isBaby;
    }

    public void setIsBaby(Boolean baby) {
        isBaby = baby;
    }

    public Boolean getLegendary() {
        return isLegendary;
    }

    public void setLegendary(Boolean legendary) {
        isLegendary = legendary;
    }

    public Boolean getMythical() {
        return isMythical;
    }

    public void setMythical(Boolean mythical) {
        isMythical = mythical;
    }

    public BaseModel getColor() {
        return color;
    }

    public void setColor(BaseModel color) {
        this.color = color;
    }

    public BaseModel getHabitat() {
        return habitat;
    }

    public void setHabitat(BaseModel habitat) {
        this.habitat = habitat;
    }

    public BaseModel getShape() {
        return shape;
    }

    public void setShape(BaseModel shape) {
        this.shape = shape;
    }
}
