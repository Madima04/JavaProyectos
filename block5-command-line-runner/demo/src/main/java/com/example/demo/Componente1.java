package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Componente1 {

    @PostConstruct
    public void componente1() {
        System.out.println("Hola desde clase principal");
    }
}
