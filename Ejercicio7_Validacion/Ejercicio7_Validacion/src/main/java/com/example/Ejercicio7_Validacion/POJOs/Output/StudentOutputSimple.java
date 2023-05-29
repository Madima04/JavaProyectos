package com.example.Ejercicio7_Validacion.POJOs.Output;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentOutputSimple {
    Integer id_string;
    PersonaOutput persona;
    String branch;

}
