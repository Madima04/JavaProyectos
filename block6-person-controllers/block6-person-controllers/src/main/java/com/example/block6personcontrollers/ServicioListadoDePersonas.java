package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioListadoDePersonas {
    private List<Persona> listaPersonas;

    public ServicioListadoDePersonas() {
        Persona bean1 = new Persona("bean1", "bean1", 1);
        Persona bean2 = new Persona("bean2", "bean2", 1);
        Persona bean3 = new Persona("bean3", "bean3", 1);
    }
    @Qualifier("bean1")
    @Bean
    public Persona informacionBean1(){
        return new Persona("bean1", "bean1", 1);
    }
    @Qualifier("bean2")
    @Bean
    public Persona informacionBean2(){
        return new Persona("bean2", "bean2", 1);
    }

    @Qualifier("bean3")
    @Bean
    public Persona informacionBean3(){
        return new Persona("bean3", "bean3", 1);
    }
}
