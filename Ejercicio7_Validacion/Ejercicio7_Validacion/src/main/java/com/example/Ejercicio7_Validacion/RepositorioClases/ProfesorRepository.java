package com.example.Ejercicio7_Validacion.RepositorioClases;

import com.example.Ejercicio7_Validacion.POJOs.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
}
