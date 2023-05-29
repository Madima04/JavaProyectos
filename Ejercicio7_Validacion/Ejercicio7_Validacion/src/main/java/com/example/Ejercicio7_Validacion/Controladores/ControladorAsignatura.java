package com.example.Ejercicio7_Validacion.Controladores;


import com.example.Ejercicio7_Validacion.POJOs.Input.Estudiante_asignaturaInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.Estudiante_asignaturaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Servicios.InterfaceServicioAsignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
