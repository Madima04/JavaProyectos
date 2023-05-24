package com.example.block5properties;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class Controlador1 {
    private Componente1 componente1;

    public Controlador1(Componente1 componente1) {
        this.componente1 = componente1;
    }

    public Componente1 getComponente1() {
        return componente1;
    }
    @GetMapping("/")
    public String greeting() {
        return componente1.info();
    }
}
