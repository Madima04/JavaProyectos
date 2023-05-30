package com.example.Ejercicio7_Validacion.POJOs.Output;

import com.example.Ejercicio7_Validacion.POJOs.Student;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class Estudiante_asignaturaOutput {

    Integer id_asignatura;
    Set<StudentOutputFull> estudiantes;
    String asignatura;
    Date initial_date;
    Date finish_date;
}
