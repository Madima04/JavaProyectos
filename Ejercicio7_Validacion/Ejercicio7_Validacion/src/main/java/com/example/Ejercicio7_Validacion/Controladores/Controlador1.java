package com.example.Ejercicio7_Validacion.Controladores;

import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Input.StudentInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputFull;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputSimple;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.POJOs.Profesor;
import com.example.Ejercicio7_Validacion.POJOs.Student;
import com.example.Ejercicio7_Validacion.Excepciones.EntityNotFoundException;
import com.example.Ejercicio7_Validacion.Repositorio.Estudiante_asignaturaRepository;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;
import com.example.Ejercicio7_Validacion.Repositorio.ProfesorRepository;
import com.example.Ejercicio7_Validacion.Repositorio.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/escuela")
public class Controlador1 {


    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    Estudiante_asignaturaRepository estudiante_asignaturaRepository;

    @PostMapping("/addPersona")
    @ResponseBody
    public PersonaOutput addPersona(@RequestBody PersonaImput persona){
        Persona p = new Persona(persona);
        personaRepository.save(p);
        return p.parsePersonaOutputDTO(p);
    }

    @PostMapping("/addStudent")
    @ResponseBody
    public StudentOutputSimple addStudent(@RequestBody StudentInput student){
         Student studentGuardado = new Student(student, personaRepository);
         studentRepository.save(studentGuardado);
         return studentGuardado.toStudentOutputSimple(studentGuardado);
    }

    @PutMapping("/updateStudent/{id}")
    public Object setStudent(@PathVariable Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setNum_hours_week(student.getNum_hours_week());
            student.setBranch(student.getBranch());
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
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
