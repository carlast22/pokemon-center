package com.pokemon.center.mapping.dto;

public class PokemonPersonDTO {
    private int pokemonPersonId;
    private int personId;
    private int pokemonId;
    private String pokemonNickname;
    private double height;
    private double weight;

    public int getPokemonPersonId() {
        return pokemonPersonId;
    }

    public void setPokemonPersonId(int pokemonPersonId) {
        this.pokemonPersonId = pokemonPersonId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getPokemonNickname() {
        return pokemonNickname;
    }

    public void setPokemonNickname(String pokemonNickname) {
        this.pokemonNickname = pokemonNickname;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
