package com.example.Ejercicio7_Validacion.POJOs.Servicios;

import com.example.Ejercicio7_Validacion.POJOs.Input.ProfesorInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.ProfesorOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.POJOs.Profesor;
import com.example.Ejercicio7_Validacion.POJOs.Student;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;
import com.example.Ejercicio7_Validacion.Repositorio.ProfesorRepository;
import com.example.Ejercicio7_Validacion.Repositorio.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProfesorService implements InterfaceServicioProfesor{

    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    StudentRepository studentRepository;

    public ProfesorOutput addProfesorService(ProfesorInput profesorInput){
        if(PersonaIsStudentOrProfesor(profesorInput.getId_persona())){
            throw new RuntimeException("La persona ya es un estudiante o profesor");
        }
        Profesor p = new Profesor(profesorInput, personaRepository);
        profesorRepository.save(p);
        return p.parsePersonaOutputDTO(p);
    }

    private boolean PersonaIsStudentOrProfesor(int idPersona) {
        Optional<Persona> personaOptional = personaRepository.findById(idPersona);
        Optional<Student> studentOptional = studentRepository.findById(idPersona);
        Optional<Profesor> profesorOptional = profesorRepository.findById(idPersona);
        if(personaOptional.isPresent()){
            if(studentOptional.isPresent() || profesorOptional.isPresent()){
                return true;
            }
        }
        return false;
    }
}
