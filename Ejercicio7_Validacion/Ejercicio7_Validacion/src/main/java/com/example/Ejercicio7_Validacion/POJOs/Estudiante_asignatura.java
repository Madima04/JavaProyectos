package com.example.Ejercicio7_Validacion.POJOs;

import com.example.Ejercicio7_Validacion.POJOs.Input.Estudiante_asignaturaInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.Estudiante_asignaturaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputSimple;
import com.example.Ejercicio7_Validacion.Repositorio.StudentRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante_asignatura")
public class Estudiante_asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    Integer id_asignatura;
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Student> estudiantes;
    String asignatura;
    @NotNull
    Date initial_date;
    Date finish_date;

    public Estudiante_asignatura(Estudiante_asignaturaInput estudiante_asignaturaInputDTO) {
        estudiantes = new HashSet<>();
        this.id_asignatura = estudiante_asignaturaInputDTO.getId_asignatura();

        this.asignatura = estudiante_asignaturaInputDTO.getAsignatura();
        this.initial_date = estudiante_asignaturaInputDTO.getInitial_date();
        this.finish_date = estudiante_asignaturaInputDTO.getFinish_date();
    }


    private Set<StudentOutputSimple> transformadorOutput(Set<Student> estudiantes) {
        Set<StudentOutputSimple> estudiantesOutput = new HashSet<>();
        for (Student student : estudiantes) {
            estudiantesOutput.add(student.toStudentOutputSimple(student));
        }
        return estudiantesOutput;
    }

    public Estudiante_asignaturaOutput toEstudiante_asignaturaOutput(Estudiante_asignatura estudiante_asignatura) {
        Estudiante_asignaturaOutput estudiante_asignaturaOutput = new Estudiante_asignaturaOutput();
        estudiante_asignaturaOutput.setId_asignatura(estudiante_asignatura.getId_asignatura());
        estudiante_asignaturaOutput.setEstudiantes(transformadorOutput(estudiante_asignatura.getEstudiantes()));
        estudiante_asignaturaOutput.setAsignatura(estudiante_asignatura.getAsignatura());
        estudiante_asignaturaOutput.setInitial_date(estudiante_asignatura.getInitial_date());
        estudiante_asignaturaOutput.setFinish_date(estudiante_asignatura.getFinish_date());
        return estudiante_asignaturaOutput;
    }

}
