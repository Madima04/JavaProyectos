package com.example.Ejercicio7_Validacion.POJOs.ServiciosClases;


import com.example.Ejercicio7_Validacion.POJOs.Input.ProfesorInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.ProfesorOutput;

public interface InterfaceServicioProfesor {

    public ProfesorOutput addProfesorService(ProfesorInput profesorInput);

    ProfesorOutput getProfesorService(int id);
}
