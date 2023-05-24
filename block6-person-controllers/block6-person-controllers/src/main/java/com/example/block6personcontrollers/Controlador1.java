package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/controlador1")
public class Controlador1 {
    private ServicioPersona servicioPersona;
    private ServiciosListadoDeCiudades ServiciosListadoDeCiudades;

    public Controlador1(ServicioPersona servicioPersona, ServiciosListadoDeCiudades ServiciosListadoDeCiudades) {
        this.servicioPersona = servicioPersona;
        this.ServiciosListadoDeCiudades = ServiciosListadoDeCiudades;
    }

    @GetMapping("/addPersona")
    public Persona addPersona(
            @RequestHeader("nombre") String nombre,
            @RequestHeader("poblacion") String poblacion,
            @RequestHeader("edad") int edad) {
        return servicioPersona.crearPersona(nombre, poblacion, edad);
    }

    @PostMapping("/addCiudad")
    public Ciudad addCiudad(@RequestBody Ciudad ciudad) {
        ServiciosListadoDeCiudades.addCiudad(ciudad);
        return servicioPersona.crearCiudad(ciudad.getNombre(), ciudad.getPoblacion());
    }

}
