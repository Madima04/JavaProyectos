package com.example.Ejercicio7_Validacion.POJOs.ServiciosClases;

import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InterfaceServicioPersona {

    public Map<Integer, List<Persona>> getData(HashMap<String, Object> conditions, String order);
    public PersonaOutput addPersonaService(PersonaImput persona);

    List<PersonaOutput> getOutput(List<Persona> lista);

    void addPersona(PersonaImput persona);
}
