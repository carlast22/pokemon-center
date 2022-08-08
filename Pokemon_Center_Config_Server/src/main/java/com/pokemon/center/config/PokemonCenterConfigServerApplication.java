package com.pokemon.center.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class PokemonCenterConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonCenterConfigServerApplication.class, args);
    }

}
