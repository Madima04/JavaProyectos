package com.example.Ejercicio7_Validacion.POJOs.Output;

import com.example.Ejercicio7_Validacion.POJOs.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class StudentOutputFull {
    Integer id_string;
    PersonaOutput persona;
    int num_hours_week;
    ProfesorOutput profesor;
    String branch;
    Set<Estudiante_asignaturaOutput> estudios;
}
