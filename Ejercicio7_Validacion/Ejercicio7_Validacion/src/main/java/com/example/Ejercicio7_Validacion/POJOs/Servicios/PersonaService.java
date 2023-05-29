package com.example.Ejercicio7_Validacion.POJOs.Servicios;

import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaService implements InterfaceServicioPersona {

    @Autowired
    PersonaRepository personaRepository;

    public PersonaOutput addPersonaService(PersonaImput persona){
        Persona p = new Persona(persona);
        personaRepository.save(p);
        return p.parsePersonaOutputDTO(p);
    }
}
