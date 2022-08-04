package com.pokemon.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//anotacion para indicarle a spring donde debe buscar clases anotadas
@ComponentScan(basePackages = {"com.pokemon.center.*", "com.pokemon.center.utilities"})
//utilizamos esta anotacion para decirle a spring que busque en este paquete las entidades
@EntityScan(basePackages = {"com.pokemon.center.persistence"})
//Le indicamos la ruta donde tenemos las clases anotadas como repositorie
@EnableJpaRepositories(basePackages = {"com.pokemon.center.dao"})

@SpringBootApplication
public class PokemonCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonCenterApplication.class, args);
    }

}
