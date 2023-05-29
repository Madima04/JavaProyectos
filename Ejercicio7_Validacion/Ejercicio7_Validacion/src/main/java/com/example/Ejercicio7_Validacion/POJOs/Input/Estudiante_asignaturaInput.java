package com.example.Ejercicio7_Validacion.POJOs.Input;

import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputSimple;
import com.example.Ejercicio7_Validacion.POJOs.Student;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class Estudiante_asignaturaInput {

    Integer id_asignatura;
    Set<Integer> estudiantes;
    String asignatura;
    Date initial_date;
    Date finish_date;

}
