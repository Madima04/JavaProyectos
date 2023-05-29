package com.example.Ejercicio7_Validacion.Controladores;

import com.example.Ejercicio7_Validacion.POJOs.*;
import com.example.Ejercicio7_Validacion.POJOs.Output.*;
import com.example.Ejercicio7_Validacion.POJOs.Input.*;
import com.example.Ejercicio7_Validacion.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/escuela")
public class ControladorEstudiante {


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

    @GetMapping("/findStudent/{id}")
    public Object getId(@PathVariable Integer id, @RequestParam(value = "type", defaultValue = "simple") String type) {
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

    @PutMapping("/updateStudent/{id}")
    public Object setStudent(@PathVariable Integer id, @RequestBody StudentInput studentInput){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setBranch(studentInput.getBranch());
            student.setNum_hours_week(studentInput.getNum_hours_week());
            student.setPersona(personaRepository.findById(studentInput.getId_persona()).get());
            studentRepository.save(student);
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
