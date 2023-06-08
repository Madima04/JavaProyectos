package com.example.Ejercicio7_Validacion.POJOs.Output;

import com.example.Ejercicio7_Validacion.POJOs.Persona;
import lombok.Data;

@Data
public class ProfesorOutput {
    Integer id_profesor;
    PersonaOutput persona;
    String branch;

    public Integer setId_string(Integer idProfesor) {
        return id_profesor;
    }

    public void setId(int i) {
        this.id_profesor = i;
    }
}
