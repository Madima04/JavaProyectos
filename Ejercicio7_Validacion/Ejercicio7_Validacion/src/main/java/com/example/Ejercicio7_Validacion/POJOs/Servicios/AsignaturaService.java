package com.example.Ejercicio7_Validacion.POJOs.Servicios;

import com.example.Ejercicio7_Validacion.POJOs.Estudiante_asignatura;
import com.example.Ejercicio7_Validacion.POJOs.Input.Estudiante_asignaturaInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.Estudiante_asignaturaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Student;
import com.example.Ejercicio7_Validacion.Repositorio.Estudiante_asignaturaRepository;
import com.example.Ejercicio7_Validacion.Repositorio.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
@RestController
public class AsignaturaService implements InterfaceServicioAsignatura{

    @Autowired
    Estudiante_asignaturaRepository estudiante_asignaturaRepository;

    @Autowired
    StudentRepository studentRepository;

    public Estudiante_asignaturaOutput addAsignaturaService(Estudiante_asignaturaInput estudiante_asignaturaInput) {
        Estudiante_asignatura estudiante_asignatura = new Estudiante_asignatura(estudiante_asignaturaInput);
        estudiante_asignatura.setEstudiantes(getEstudiantesPorId(estudiante_asignaturaInput.getEstudiantes()));
        estudiante_asignaturaRepository.save(estudiante_asignatura);
        guardarEstudiantes(estudiante_asignatura);
        return estudiante_asignatura.toEstudiante_asignaturaOutput(estudiante_asignatura);
    }

    private void guardarEstudiantes(Estudiante_asignatura estudianteAsignatura) {
        for (Student estudiante : estudianteAsignatura.getEstudiantes()) {
            estudiante.getEstudiante_asignaturas().add(estudianteAsignatura);
            studentRepository.save(estudiante);
        }
    }

    public Set<Student> getEstudiantesPorId(Set<Integer> estudiantesId) {
        Set<Student> estudiantes = new HashSet<>();
        for (Integer id : estudiantesId) {
            estudiantes.add(studentRepository.findById(id).get());
        }
        return estudiantes;
    }

}
