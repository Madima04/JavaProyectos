package com.example.Ejercicio7_Validacion.POJOs;

import com.example.Ejercicio7_Validacion.POJOs.Input.StudentInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputFull;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputSimple;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@NoArgsConstructor
@Entity
@Data
@Table(name = "estudiante")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_Student;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @NotNull
    int num_hours_week;
    /*    @OneToOne
        @JoinColumn(name="id_profesor")
        Profesor profesor;*/
    @ManyToMany (mappedBy = "estudiantes")
    Set<Estudiante_asignatura> estudios;
    @NotNull
    String branch;

    public Student(StudentInput studentin, PersonaRepository personaRepository) {
        this.id_Student = studentin.getId_string();
        this.num_hours_week = studentin.getNum_hours_week();
        this.branch = studentin.getBranch();
        this.persona = personaRepository.findById(studentin.getId_persona()).get();
    }

    public StudentOutputSimple toStudentOutputSimple(Student student) {
        StudentOutputSimple studentOutputSimple = new StudentOutputSimple();
        studentOutputSimple.setId_string(student.getId_Student());
        studentOutputSimple.setBranch(student.getBranch());
        studentOutputSimple.setPersona(this.persona.parsePersonaOutputDTO(this.persona));
        return studentOutputSimple;
    }


    public StudentOutputFull toStudentOutputFull(Student student) {
        StudentOutputFull studentOutputFull = new StudentOutputFull();
        studentOutputFull.setId_string(student.getId_Student());
        studentOutputFull.setBranch(student.getBranch());
        studentOutputFull.setNum_hours_week(student.getNum_hours_week());
        studentOutputFull.setPersona(this.persona.parsePersonaOutputDTO(this.persona));
        return studentOutputFull;
    }

}
