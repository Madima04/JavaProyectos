package com.example.block6personcontrollers;

import org.springframework.stereotype.Service;

@Service
public class ServicioPersona {
    private Persona persona;

    public Persona crearPersona(String nombre, String poblacion, int edad) {
        this.persona = new Persona(nombre, poblacion, edad);
        return persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public Ciudad crearCiudad(String nombre, int poblacion) {
        return new Ciudad(nombre, poblacion);
    }
}

