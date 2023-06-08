package com.example.Ejercicio7_Validacion.Controladores;

import com.example.Ejercicio7_Validacion.POJOs.Input.ProfesorInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.ProfesorOutput;
import com.example.Ejercicio7_Validacion.POJOs.ServiciosClases.InterfaceServicioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class ControladorProfesor {

    @Autowired
    InterfaceServicioProfesor servicioProfesor;

    @PostMapping("/add")
    public ProfesorOutput addProfesor(@RequestBody ProfesorInput persona){
        return servicioProfesor.addProfesorService(persona);
    }

    @GetMapping("/get/{id}")
    public ProfesorOutput getProfesor(@PathVariable int id){
        return servicioProfesor.getProfesorService(id);
    }
}
