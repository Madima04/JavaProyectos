package com.example.Ejercicio7_Validacion.POJOs.ServiciosClases;

import com.example.Ejercicio7_Validacion.POJOs.Estudiante_asignatura;
import com.example.Ejercicio7_Validacion.POJOs.Input.Estudiante_asignaturaInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.Estudiante_asignaturaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.StudentOutputSimple;
import com.example.Ejercicio7_Validacion.POJOs.Student;
import com.example.Ejercicio7_Validacion.RepositorioClases.Estudiante_asignaturaRepository;
import com.example.Ejercicio7_Validacion.RepositorioClases.StudentRepository;
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
        return estudiante_asignatura.toEstudiante_asignaturaOutput(estudiante_asignatura);
    }


    public Set<Student> getEstudiantesPorId(Set<Integer> estudiantesId) {
        if (estudiantesId== null) return null;
        Set<Student> estudiantes = new HashSet<>();
        for (Integer id : estudiantesId) {
            estudiantes.add(studentRepository.findById(id).get());
        }
        return estudiantes;
    }

    /*public Set<Estudiante_asignaturaOutput> getAsignaturaService(Set<Integer> id) {
        Set<Estudiante_asignaturaOutput> estudiante_asignaturaOutputs = new HashSet<>();
        for (Integer id1 : id) {
            for (Estudiante_asignatura estudiante_asignatura : estudiante_asignaturaRepository.findAll()) {
                if (estudiante_asignatura.getId_asignatura().equals(id1)) {
                    estudiante_asignaturaOutputs.add(estudiante_asignatura.toEstudiante_asignaturaOutput(estudiante_asignatura));
                }
            }
        }
        return estudiante_asignaturaOutputs;
    }*/

    @Override
    public Estudiante_asignaturaOutput getAsignaturaService(Integer id) {
        Estudiante_asignatura estudiante_asignatura = estudiante_asignaturaRepository.findById(id).orElseThrow();
        estudiante_asignatura.setEstudiantes(getEstudiantesPorId(estudiante_asignatura.getEstudiantesId(id)));
        Set<StudentOutputSimple> estudiantes = new HashSet<>();
        Estudiante_asignaturaOutput estudiante_asignaturaOutput = estudiante_asignatura.toEstudiante_asignaturaOutput(estudiante_asignatura);
        estudiante_asignatura.getEstudiantes().forEach( e ->  estudiantes.add(e.toStudentOutputSimple(e)));
        return estudiante_asignaturaOutput;
    }

    @Override
    public Set<Integer> getEstudiantesId(Integer id) {
        return estudiante_asignaturaRepository.findById(id).get().getEstudiantesId(id);
    }

}
