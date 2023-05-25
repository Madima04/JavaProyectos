package com.example.Ejercicio7_Validacion.POJOs.Input;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class StudentInput {

    int id_string;
    int id_persona;
    int num_hours_week;
    int id_profesor;
    String branch;

}
