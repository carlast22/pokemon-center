# Utilities module for Pokemon Center project
This module contains logic for common uses in Spring Boot based projects
To use this module its necesary to add this into the pom.xml

      <dependency>
            <groupId>com.pokemon.center.utilities</groupId>
            <artifactId>Utilities</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>

## Custom Handler Exception
There is a custom exception called PokemonCenterException, this is useful for controlled
exceptions in the project, also a handler for this exceptions and for uncontrolled exceptions is added.

To use this utility its necesary to add the package name of this project to the component scan in the desired problem

`@ComponentScan(basePackages = {"com.pokemon.center.utilities"})`

## Response Manager
This utility its meant to manage responses into a predefined envelope response of type ResponseObjectAbstract

To use this utility its necesary to add the package name of this project to the component scan in the desired problem
And extend the ResponseManager class, there are multiple getResponseEntity methods for multiple cases of response.

`@ComponentScan(basePackages = {"com.pokemon.center.utilities"})`

