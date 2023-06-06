package com.example.Ejercicio7_Validacion.POJOs.Servicios;

import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;

import java.util.HashMap;
import java.util.List;

public interface InterfaceServicioPersona {

    public List<Persona> getData(HashMap<String, Object> conditions);
    public PersonaOutput addPersonaService(PersonaImput persona);

    List<PersonaOutput> getOutput(List<Persona> lista);
}
