package com.pokemon.center.persistence;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pokemon {
    private Integer pokId;
    private Integer pokApiId;
    private String pokName;
    private String pokGender;
    private String pokImage;
    private String pokSpecies;
    private String pokColors;
    private String pokHabitat;
    private String pokShape;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pok_id")
    public Integer getPokId() {
        return pokId;
    }

    public void setPokId(Integer pokId) {
        this.pokId = pokId;
    }

    @Basic
    @Column(name = "pok_api_id")
    public Integer getPokApiId() {
        return pokApiId;
    }

    public void setPokApiId(Integer pokApiId) {
        this.pokApiId = pokApiId;
    }

    @Basic
    @Column(name = "pok_name")
    public String getPokName() {
        return pokName;
    }

    public void setPokName(String pokName) {
        this.pokName = pokName;
    }

    @Basic
    @Column(name = "pok_gender")
    public String getPokGender() {
        return pokGender;
    }

    public void setPokGender(String pokGender) {
        this.pokGender = pokGender;
    }

    @Basic
    @Column(name = "pok_image")
    public String getPokImage() {
        return pokImage;
    }

    public void setPokImage(String pokImage) {
        this.pokImage = pokImage;
    }

    @Basic
    @Column(name = "pok_species")
    public String getPokSpecies() {
        return pokSpecies;
    }

    public void setPokSpecies(String pokSpecies) {
        this.pokSpecies = pokSpecies;
    }

    @Basic
    @Column(name = "pok_colors")
    public String getPokColors() {
        return pokColors;
    }

    public void setPokColors(String pokColors) {
        this.pokColors = pokColors;
    }

    @Basic
    @Column(name = "pok_habitat")
    public String getPokHabitat() {
        return pokHabitat;
    }

    public void setPokHabitat(String pokHabitat) {
        this.pokHabitat = pokHabitat;
    }

    @Basic
    @Column(name = "pok_shape")
    public String getPokShape() {
        return pokShape;
    }

    public void setPokShape(String pokShape) {
        this.pokShape = pokShape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(pokId, pokemon.pokId) && Objects.equals(pokApiId, pokemon.pokApiId) && Objects.equals(pokName, pokemon.pokName) && Objects.equals(pokGender, pokemon.pokGender) && Objects.equals(pokImage, pokemon.pokImage) && Objects.equals(pokSpecies, pokemon.pokSpecies) && Objects.equals(pokColors, pokemon.pokColors) && Objects.equals(pokHabitat, pokemon.pokHabitat) && Objects.equals(pokShape, pokemon.pokShape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokId, pokApiId, pokName, pokGender, pokImage, pokSpecies, pokColors, pokHabitat, pokShape);
    }
}
