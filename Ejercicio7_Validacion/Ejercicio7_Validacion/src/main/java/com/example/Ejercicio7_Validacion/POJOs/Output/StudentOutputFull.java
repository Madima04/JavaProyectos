package com.example.Ejercicio7_Validacion.POJOs.Output;

import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.POJOs.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentOutputFull {
    Integer id_string;
    PersonaOutput persona;
    int num_hours_week;
    ProfesorOutput profesor;
    String branch;

}
