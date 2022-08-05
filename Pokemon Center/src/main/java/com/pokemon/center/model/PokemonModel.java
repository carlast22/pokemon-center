package com.pokemon.center.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class PokemonModel {
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public SpriteModel getSprites() {
        return sprites;
    }

    public void setSprites(SpriteModel sprites) {
        this.sprites = sprites;
    }

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("height")
    private String height;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("sprites")
    private SpriteModel sprites;
}
