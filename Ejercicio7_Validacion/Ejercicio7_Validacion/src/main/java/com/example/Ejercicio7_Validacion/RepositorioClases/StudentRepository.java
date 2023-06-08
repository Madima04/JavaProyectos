package com.example.Ejercicio7_Validacion.RepositorioClases;

import com.example.Ejercicio7_Validacion.POJOs.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
