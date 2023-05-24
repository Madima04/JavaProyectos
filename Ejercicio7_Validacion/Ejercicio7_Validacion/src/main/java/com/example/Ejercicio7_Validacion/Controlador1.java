package com.example.Ejercicio7_Validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@ControllerAdvice
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

    @PostMapping("/addStudent")
    public Student addStudent(Student student) throws EntityNotFoundException {
        Optional<Student> studentOptional = Optional.ofNullable(student);
        if(studentOptional.isPresent()){
            return studentRepository.save(student);
        }
        throw new EntityNotFoundException("El estudiante no puede ser nulo");
    }

    @GetMapping("/id/{id}")
    public Object getId(@PathVariable Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
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
