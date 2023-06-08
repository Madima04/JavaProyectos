package com.example.Ejercicio7_Validacion.POJOs.ServiciosClases;

import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Input.StudentInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputSimple;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface InterfaceServicioEstudiante {
    public PersonaOutput addPersonaService(PersonaImput persona);
    public PersonaOutput addPersonaService(Persona persona);
    public StudentOutputSimple addStudentService(StudentInput student) throws Exception;
    public Object getIdService(Integer id, String type);
    public Object setStudentService(Integer id, StudentInput studentInput);
    public Object deleteStudent(@PathVariable Integer id);
    List<PersonaOutput> getAllPersonasService();
    PersonaOutput addPersonaService2(Persona persona);
}
