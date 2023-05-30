package com.example.Ejercicio7_Validacion.POJOs.Servicios;

import com.example.Ejercicio7_Validacion.POJOs.Estudiante_asignatura;
import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Input.StudentInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputSimple;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.POJOs.Student;
import com.example.Ejercicio7_Validacion.Repositorio.Estudiante_asignaturaRepository;
import com.example.Ejercicio7_Validacion.Repositorio.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
public class EstudianteService implements InterfaceServicioEstudiante{

    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    Estudiante_asignaturaRepository estudiante_asignaturaRepository;

    public PersonaOutput addPersonaService(PersonaImput persona){
        Persona p = new Persona(persona);
        personaRepository.save(p);
        return p.parsePersonaOutputDTO(p);
    }

    public StudentOutputSimple addStudentService( StudentInput student){
        Student studentGuardado = new Student(student, personaRepository, estudiante_asignaturaRepository);
        studentRepository.save(studentGuardado);
        return studentGuardado.toStudentOutputSimple(studentGuardado);
    }

    public Object getIdService(Integer id, String type) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            if (type.equals("simple")) {
                return student.toStudentOutputSimple(student);
            } else if (type.equals("full")) {
                return student.toStudentOutputFull(student);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Object setStudentService(Integer id, StudentInput studentInput){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setBranch(studentInput.getBranch());
            student.setNum_hours_week(studentInput.getNum_hours_week());
            student.setPersona(personaRepository.findById(studentInput.getId_persona()).get());
            student.setEstudios(buscarEstudiosPorId(studentInput.getId_asignatura()));
            studentRepository.save(student);
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    private Set<Estudiante_asignatura> buscarEstudiosPorId(Set<Integer> id_asingatura) {
        Set<Estudiante_asignatura> estudios = new HashSet<>();
        if (id_asingatura == null) {
            return estudios;
        }
        for (Integer id : id_asingatura) {
            estudios.add(estudiante_asignaturaRepository.findById(id).get());
        }
        return estudios;
    }

    public Object deleteStudent(@PathVariable Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            studentRepository.delete(student);
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
