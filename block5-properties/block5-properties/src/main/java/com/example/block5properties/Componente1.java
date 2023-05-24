package com.example.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Componente1 implements CommandLineRunner {

    public Componente1() {
        System.out.println("Componente1 creado.");
    }

    @Value("${greeting: no tiene valor}")
    private String greeting;

    @Value("${my.number: El valor de my.number no se ha especificado.}")
    private String myNumber;

    @Value("${my.property: El valor de my.property no se ha especificado.}")
    private String myProperty;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("El valor de greeting es: " + greeting + ".");
        System.out.println("El valor de my.number es: " + myNumber + ".");
        System.out.println("El valor de my.property es: " + myProperty + ".");
    }

    public String info() {
        return "El valor de greeting es: " + greeting + "." +
                "\nEl valor de my.number es: " + myNumber + "." +
                "\nEl valor de my.property es: " + myProperty + ".";
    }
}
