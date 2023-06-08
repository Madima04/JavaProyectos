package com.example.Ejercicio7_Validacion.POJOs.ServiciosClases;

import com.example.Ejercicio7_Validacion.POJOs.Input.Estudiante_asignaturaInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.Estudiante_asignaturaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Student;

import java.util.Set;

public interface InterfaceServicioAsignatura {
    public Estudiante_asignaturaOutput addAsignaturaService(Estudiante_asignaturaInput estudiante_asignaturaInput);
    public Set<Student> getEstudiantesPorId(Set<Integer> estudiantesId);
//    public Set<Estudiante_asignaturaOutput> getAsignaturaService(Set<Integer> id);
    public Estudiante_asignaturaOutput getAsignaturaService(Integer id);

    public Set<Integer> getEstudiantesId(Integer id);

}
