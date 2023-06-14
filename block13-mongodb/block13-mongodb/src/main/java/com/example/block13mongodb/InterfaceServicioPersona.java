package com.example.block13mongodb;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InterfaceServicioPersona {

    public Map<Integer, List<Persona>> getData(HashMap<String, Object> conditions, String order);
    public PersonaOutput addPersonaService(PersonaImput persona);

    List<PersonaOutput> getOutput(List<Persona> lista);

    void addPersona(PersonaImput persona);
}
