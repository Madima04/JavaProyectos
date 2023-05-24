package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Componente2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola desde la clase secundaria");
    }
}
