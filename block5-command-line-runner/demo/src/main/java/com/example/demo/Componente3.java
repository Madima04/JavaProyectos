package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Componente3 implements CommandLineRunner {

    @Value("${project.name}")
    private String name;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola desde la clase terciaria: " +  name);
    }

}
