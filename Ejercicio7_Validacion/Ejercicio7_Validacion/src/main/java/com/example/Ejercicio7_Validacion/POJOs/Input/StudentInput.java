package com.example.Ejercicio7_Validacion.POJOs.Input;

import com.example.Ejercicio7_Validacion.POJOs.Estudiante_asignatura;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
public class StudentInput {

    int id_string;
    int id_persona;
    int num_hours_week;
    int id_profesor;
    String branch;
    Set<Integer> id_asingatura;

    public Set<Integer> getId_asignatura() {
        return id_asingatura;
    }
}
