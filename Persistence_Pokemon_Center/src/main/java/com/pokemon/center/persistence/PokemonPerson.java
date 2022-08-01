package com.pokemon.center.persistence;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Pokemon_Person", schema = "pokemon_center", catalog = "")
public class PokemonPerson {
    private Integer pokPerId;
    private String pokPerNickname;
    private Boolean pokPerActive;
    private Timestamp pokPerCreatedAt;
    private Pokemon pokPerPokId;
    private Person pokPerPerId;
    private Double pokPerHeight;
    private Double pokPerWeight;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pok_per_id")
    public Integer getPokPerId() {
        return pokPerId;
    }

    public void setPokPerId(Integer pokPerId) {
        this.pokPerId = pokPerId;
    }

    @Basic
    @Column(name = "pok_per_nickname")
    public String getPokPerNickname() {
        return pokPerNickname;
    }

    public void setPokPerNickname(String pokPerNickname) {
        this.pokPerNickname = pokPerNickname;
    }

    @Basic
    @Column(name = "pok_per_active")
    public Boolean getPokPerActive() {
        return pokPerActive;
    }

    public void setPokPerActive(Boolean pokPerActive) {
        this.pokPerActive = pokPerActive;
    }

    @Basic
    @Column(name = "pok_per_created_at")
    public Timestamp getPokPerCreatedAt() {
        return pokPerCreatedAt;
    }

    public void setPokPerCreatedAt(Timestamp pokPerCreatedAt) {
        this.pokPerCreatedAt = pokPerCreatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonPerson that = (PokemonPerson) o;
        return Objects.equals(pokPerId, that.pokPerId) && Objects.equals(pokPerNickname, that.pokPerNickname) && Objects.equals(pokPerActive, that.pokPerActive) && Objects.equals(pokPerCreatedAt, that.pokPerCreatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokPerId, pokPerNickname, pokPerActive, pokPerCreatedAt);
    }

    @ManyToOne
    @JoinColumn(name = "pok_per_pok_id", referencedColumnName = "pok_id", nullable = false)
    public Pokemon getPokPerPokId() {
        return pokPerPokId;
    }

    public void setPokPerPokId(Pokemon pokPerPokId) {
        this.pokPerPokId = pokPerPokId;
    }

    @ManyToOne
    @JoinColumn(name = "pok_per_per_id", referencedColumnName = "per_id", nullable = false)
    public Person getPokPerPerId() {
        return pokPerPerId;
    }

    public void setPokPerPerId(Person pokPerPerId) {
        this.pokPerPerId = pokPerPerId;
    }

    @Basic
    @Column(name = "pok_per_height")
    public Double getPokPerHeight() {
        return pokPerHeight;
    }

    public void setPokPerHeight(Double pokPerHeight) {
        this.pokPerHeight = pokPerHeight;
    }

    @Basic
    @Column(name = "pok_per_weight")
    public Double getPokPerWeight() {
        return pokPerWeight;
    }

    public void setPokPerWeight(Double pokPerWeight) {
        this.pokPerWeight = pokPerWeight;
    }
}
