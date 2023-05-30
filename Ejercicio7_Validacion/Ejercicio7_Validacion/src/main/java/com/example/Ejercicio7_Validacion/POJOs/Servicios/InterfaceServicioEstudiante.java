package com.example.Ejercicio7_Validacion.POJOs.Servicios;

import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Input.StudentInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputSimple;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

public interface InterfaceServicioEstudiante {
    public PersonaOutput addPersonaService(PersonaImput persona);
    public StudentOutputSimple addStudentService(StudentInput student);
    public Object getIdService(Integer id, String type);
    public Object setStudentService(Integer id, StudentInput studentInput);
    public Object deleteStudent(@PathVariable Integer id);
}
