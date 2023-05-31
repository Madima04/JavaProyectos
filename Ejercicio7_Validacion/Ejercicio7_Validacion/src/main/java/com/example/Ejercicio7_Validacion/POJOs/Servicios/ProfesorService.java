package com.example.Ejercicio7_Validacion.POJOs.Servicios;

import com.example.Ejercicio7_Validacion.POJOs.Input.ProfesorInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.ProfesorOutput;
import com.example.Ejercicio7_Validacion.POJOs.Profesor;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;
import com.example.Ejercicio7_Validacion.Repositorio.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesorService implements InterfaceServicioProfesor{

    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaRepository personaRepository;

    public ProfesorOutput addProfesorService(ProfesorInput profesorInput){
        Profesor p = new Profesor(profesorInput, personaRepository);
        profesorRepository.save(p);
        return p.parsePersonaOutputDTO(p);
    }
}
