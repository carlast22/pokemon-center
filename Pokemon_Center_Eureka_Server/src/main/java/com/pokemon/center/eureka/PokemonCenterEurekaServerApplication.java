package com.pokemon.center.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PokemonCenterEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonCenterEurekaServerApplication.class, args);
    }

}
