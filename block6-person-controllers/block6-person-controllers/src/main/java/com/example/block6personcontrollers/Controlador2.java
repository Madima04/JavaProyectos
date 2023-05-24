package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controlador2")
public class Controlador2 {
    private ServicioPersona servicioPersona;
    private ServiciosListadoDeCiudades ServiciosListadoDeCiudades;

    public Controlador2(ServicioPersona servicioPersona, ServiciosListadoDeCiudades ServiciosListadoDeCiudades) {
        this.servicioPersona = servicioPersona;
        this.ServiciosListadoDeCiudades = ServiciosListadoDeCiudades;
    }

    @GetMapping("/getPersona")
    public Persona getPersona() {
        Persona persona = servicioPersona.getPersona();
        persona.setEdad(persona.getEdad() * 2);
        return persona;
    }

    @GetMapping("/getCiudades")
    public List<Ciudad> getCiudades(){
        return ServiciosListadoDeCiudades.getCiudades();
    }
}



