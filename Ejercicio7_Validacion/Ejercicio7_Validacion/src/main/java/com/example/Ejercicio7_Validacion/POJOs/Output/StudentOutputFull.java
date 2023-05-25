package com.example.Ejercicio7_Validacion.POJOs.Output;

import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.POJOs.Profesor;
import lombok.Data;

@Data
public class StudentOutputFull {
    Integer id_string;
    Persona persona;
    int num_hours_week;
    Profesor profesor;
    String branch;
}
