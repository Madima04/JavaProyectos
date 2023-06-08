package com.example.Ejercicio7_Validacion.RepositorioClases;

import com.example.Ejercicio7_Validacion.POJOs.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Object findByName(String name);
    Optional<Object> findByUsuario(String usuario);
}
