package com.example.Ejercicio7_Validacion.POJOs;

import com.example.Ejercicio7_Validacion.POJOs.Input.StudentInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.Estudiante_asignaturaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputFull;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputSimple;
import com.example.Ejercicio7_Validacion.RepositorioClases.Estudiante_asignaturaRepository;
import com.example.Ejercicio7_Validacion.RepositorioClases.PersonaRepository;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
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
    @OneToOne
    @JoinColumn(name="id_profesor")
    Profesor profesor;
    @ManyToMany (mappedBy = "estudiantes")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Estudiante_asignatura> estudios;
    @NotNull
    String branch;

    public Student(StudentInput studentin, PersonaRepository personaRepository, Estudiante_asignaturaRepository estudiante_asignaturaRepository) {
        this.id_Student = studentin.getId_string();
        this.num_hours_week = studentin.getNum_hours_week();
        this.branch = studentin.getBranch();
        this.persona = personaRepository.findById(studentin.getId_persona()).get();
        this.estudios = buscarEstudiosPorId(estudiante_asignaturaRepository, studentin.getId_asingatura());
    }

    private Set<Estudiante_asignatura> buscarEstudiosPorId(Estudiante_asignaturaRepository estudiante_asignaturaRepository, Set<Integer> id_asingatura) {
        Set<Estudiante_asignatura> estudios = new HashSet<>();
        if (id_asingatura == null) {
            return estudios;
        }
        for (Integer id : id_asingatura) {
            estudios.add(estudiante_asignaturaRepository.findById(id).get());
        }
        return estudios;
    }

    private Set<Estudiante_asignaturaOutput> ConvenrtidorEstudiante_asignatura(Set<Estudiante_asignatura> estudios){
        Set<Estudiante_asignaturaOutput> estudiosOutput = new HashSet<>();
        for (Estudiante_asignatura estudio : estudios) {
            estudiosOutput.add(estudio.toEstudiante_asignaturaOutput(estudio));
        }
        return estudiosOutput;
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
        studentOutputFull.setProfesor(this.profesor.parseProfesorOutputDTO(this.profesor));
        studentOutputFull.setPersona(this.persona.parsePersonaOutputDTO(this.persona));
        studentOutputFull.setEstudios(this.ConvenrtidorEstudiante_asignatura(this.estudios));
        return studentOutputFull;
    }

    public Integer getId() {
        return id_Student;
    }
}
