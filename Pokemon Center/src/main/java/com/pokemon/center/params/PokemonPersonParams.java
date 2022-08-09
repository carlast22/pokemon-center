package com.pokemon.center.params;

public class PokemonPersonParams {

    private String pokemonNickname;
    private int pokemonId;
    private int personId;
    private double height;
    private double weight;

    public String getPokemonNickname() {
        return pokemonNickname;
    }

    public void setPokemonNickname(String pokemonNickname) {
        this.pokemonNickname = pokemonNickname;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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
