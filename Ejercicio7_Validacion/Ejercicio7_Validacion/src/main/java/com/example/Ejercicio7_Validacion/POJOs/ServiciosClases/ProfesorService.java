package com.example.Ejercicio7_Validacion.POJOs.ServiciosClases;

import com.example.Ejercicio7_Validacion.POJOs.Input.ProfesorInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.ProfesorOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.POJOs.Profesor;
import com.example.Ejercicio7_Validacion.POJOs.Student;
import com.example.Ejercicio7_Validacion.RepositorioClases.PersonaRepository;
import com.example.Ejercicio7_Validacion.RepositorioClases.ProfesorRepository;
import com.example.Ejercicio7_Validacion.RepositorioClases.StudentRepository;
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

    @Override
    public ProfesorOutput getProfesorService(int id) {
        Optional<Profesor> profesorOptional = profesorRepository.findById(id);
        if(profesorOptional.isPresent()){
            return profesorOptional.get().parsePersonaOutputDTO(profesorOptional.get());
        }
        throw new RuntimeException("No se encontro el profesor");
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
