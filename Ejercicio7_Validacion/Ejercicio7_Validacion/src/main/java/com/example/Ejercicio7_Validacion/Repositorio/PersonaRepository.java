package com.example.Ejercicio7_Validacion.Repositorio;

import com.example.Ejercicio7_Validacion.POJOs.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Object findByName(String name);
}
