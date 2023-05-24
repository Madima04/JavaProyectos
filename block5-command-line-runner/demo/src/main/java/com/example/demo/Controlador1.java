package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Controlador1 {
    private Componente1 componente1;
    private Componente2 componente2;
    private Componente3 componente3;

    public Controlador1(Componente1 componente1, Componente2 componente2, Componente3 componente3) {
        this.componente1 = componente1;
        this.componente2 = componente2;
        this.componente3 = componente3;}
}
