package com.example.Ejercicio7_Validacion.Controladores;


import com.example.Ejercicio7_Validacion.POJOs.Input.Estudiante_asignaturaInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.Estudiante_asignaturaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Servicios.InterfaceServicioAsignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/escuela")
public class ControladorAsignatura {

    @Autowired
    InterfaceServicioAsignatura interfaceServicioAsignatura;

    @PostMapping("/addAsignatura")
    public Estudiante_asignaturaOutput addAsignatura(@RequestBody Estudiante_asignaturaInput estudiante_asignaturaInput){
        return interfaceServicioAsignatura.addAsignaturaService(estudiante_asignaturaInput);
    }
    @GetMapping("/findAsignatura/{id}")
    public Estudiante_asignaturaOutput getAsignatura(@PathVariable Integer id){
        return interfaceServicioAsignatura.getAsignaturaService(id);
    }

}
